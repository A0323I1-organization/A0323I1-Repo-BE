package a0323i1_cinema_professtional_be.exception;

public class ResourceNotFoundException extends RuntimeException{
    final String resourceName;
    final String fieldName;
    final long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %d", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
