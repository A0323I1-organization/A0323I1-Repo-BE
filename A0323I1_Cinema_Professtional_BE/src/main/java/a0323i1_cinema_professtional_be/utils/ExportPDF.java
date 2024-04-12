package a0323i1_cinema_professtional_be.utils;

import a0323i1_cinema_professtional_be.dto.TicketProjection;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportPDF {
//    Chiều rộng: 419.53 điểm (148mm x 72 điểm/25.4mm)
//    Chiều cao: 595.28 điểm (210mm x 72 điểm/25.4mm)
//    trong PDF kích thước của trang dc xác định bằng đơn vị đo lường là điểm (point) thay vì milimet(mm)
    public static ByteArrayInputStream ticketReport(TicketProjection ticket) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfFont vietnameseFont = PdfFontFactory.createFont("D:\\CodeGym\\FINAL\\A0323I1-organization\\A0323I1-Repo-BE\\Roboto\\Roboto-Light.ttf", PdfEncodings.IDENTITY_H,true);
        FontProvider fontProvider = new FontProvider();
        PdfWriter pdfWriter;
        PdfDocument pdfDocument;
        Document document;
        try {
            pdfWriter = new PdfWriter(outputStream);
            pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A5);
            document = new Document(pdfDocument);
            fontProvider.addFont(vietnameseFont.getFontProgram());
            document.setFontProvider(fontProvider);

            float oneCol = 420f;
            float twoCol = 210f;
            float threeColl = 140f;
            float fullWidth[] = {oneCol};
            float twoColWidth[] = {twoCol,twoCol};
            Paragraph paragraph = new Paragraph("\n");

            Table tableFullWidth = new Table(fullWidth);
            tableFullWidth.addCell(new Cell().add("VÉ XEM PHIM (TICKET)").setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            Border border = new DashedBorder(Color.GRAY,0.5f);
            Table divider = new Table(fullWidth);
            divider.setBorder(border);
            document.add(tableFullWidth.setVerticalAlignment(VerticalAlignment.BOTTOM));
            document.add(divider);

            Table tableBody = new Table(fullWidth);
            tableBody.addCell(new Cell().add(ticket.getMovieName()).setFont(vietnameseFont).setFontSize(20f).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER).setBold());
            document.add(tableBody);

            Table twoColTable = new Table(twoColWidth);
            Cell titleCell1 = getCellTitleText("Giờ(Time) :").setFont(vietnameseFont);
            Cell valueCell1 = getValueCell(String.valueOf(ticket.getMovieTime())).setFont(vietnameseFont);

            Cell titleCell2 = getCellTitleText("Ghế(Seat) :").setFont(vietnameseFont);
            Cell valueCell2 = getValueCell(ticket.getSeatName()).setFont(vietnameseFont);

            Paragraph combinedParagraph1 = new Paragraph();
            Paragraph combinedParagraph2 = new Paragraph();
            combinedParagraph1.add(titleCell1).add(valueCell1);
            combinedParagraph2.add(titleCell2).add(valueCell2);
            twoColTable.addCell(new Cell().add(combinedParagraph1).setBorder(Border.NO_BORDER));
            twoColTable.addCell(new Cell().add(combinedParagraph2).setBorder(Border.NO_BORDER));
            document.add(twoColTable);

            Table twoColTable2 = new Table(twoColWidth);
            Cell titleCell3 = getCellTitleText("Ngày(Date) :").setFont(vietnameseFont);
            Cell valueCell3 = getValueCell(String.valueOf(ticket.getShowDate())).setFont(vietnameseFont);

            Cell titleCell4 = getCellTitleText("Phòng(Room) :").setFont(vietnameseFont);
            Cell valueCell4 = getValueCell(ticket.getRoomName()).setFont(vietnameseFont);

            Paragraph combinedParagraph3 = new Paragraph();
            Paragraph combinedParagraph4 = new Paragraph();
            combinedParagraph3.add(titleCell3).add(valueCell3);
            combinedParagraph4.add(titleCell4).add(valueCell4);
            twoColTable2.addCell(new Cell().add(combinedParagraph3).setBorder(Border.NO_BORDER));
            twoColTable2.addCell(new Cell().add(combinedParagraph4).setBorder(Border.NO_BORDER));
            document.add(twoColTable2);

            Table fullColTable = new Table(fullWidth);
            Cell titleCell5 = getCellTitleText("Giá Vé(Price) :").setFont(vietnameseFont);
            Cell valueCell5 = getValueCell(ticket.getSeatPrice() + " VND").setFont(vietnameseFont);
            Paragraph combinedParagraph5 = new Paragraph();
            combinedParagraph5.add(titleCell5).add(valueCell5);
            fullColTable.addCell(new Cell().add(combinedParagraph5).setBorder(Border.NO_BORDER));
            document.add(fullColTable);
            Table twoColTable3 = new Table(twoColWidth);

            twoColTable3.addCell(new Cell().add(ticket.getFullName()+ " "+ String.valueOf(ticket.getDatePayment())).setFont(vietnameseFont).setFontSize(10f).setBorder(Border.NO_BORDER));
            twoColTable3.addCell(new Cell().add("www.cinema.com.vn").setFont(vietnameseFont).setFontSize(10f).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));

            document.add(twoColTable3);
            Table divider2 = new Table(fullWidth);
            Border border2 = new DashedBorder(Color.GRAY,0.5f);
            document.add(divider2.setBorder(border2));
            String imagePath ="D:\\CodeGym\\FINAL\\A0323I1-organization\\A0323I1-Repo-BE\\qr2.PNG";
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image image = new Image(imageData);
            document.add(image);
            Table fullColTable2 = new Table(fullWidth);
            fullColTable2.addCell(new Cell().add("Vui lòng đưa mã só này đến quầy vé Cinema để nhận vé của bạn.").setFont(vietnameseFont).setBorder(Border.NO_BORDER));
            document.add(fullColTable2);
            document.add(paragraph);
            document.add(divider.setBorder(new SolidBorder(Color.GRAY,1)).setMarginBottom(15f));
            document.close();
        }catch (Exception e){
            e.printStackTrace();
        }
     return new ByteArrayInputStream(outputStream.toByteArray());
    }

    public static Cell getCellTitleText(String textValue){
        return  new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }
    public static Cell getValueCell(String textValue){
        return new Cell().add(textValue).setBold().setFontSize(16f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }
}
