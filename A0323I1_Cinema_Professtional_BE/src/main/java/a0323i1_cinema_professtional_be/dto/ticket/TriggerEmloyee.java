package a0323i1_cinema_professtional_be.dto.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TriggerEmloyee {
    private static final Logger logger = LoggerFactory.getLogger(TriggerEmloyee.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @PostConstruct
//    public void initialize(){
//        try {
//            String triggerSql = "CREATE TRIGGER update_status_account " +
//                    "AFTER DELETE ON employee " +
//                    "FOR EACH ROW " +
//                    "BEGIN " +
//                    "   DECLARE a INT; " +
//                    "   SET a = OLD.employee_account_id; " +
//                    "   UPDATE account SET status = 0 WHERE account_id = a; " +
//                    "END;";
//            jdbcTemplate.execute(triggerSql);
//            logger.info("Trigger check_account created successfully.");
//        } catch (DataAccessException e) {
//            logger.error("Error occurred while creating trigger: {}", e.getMessage());
//        }
//    }
}




