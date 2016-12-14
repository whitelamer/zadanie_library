package netcracker.school.models;

public enum UserReaderPassportType {
    USER("USER"),
    ADMIN("ADMIN");

    String userReaderPassportType;

    private UserReaderPassportType(String userReaderPassportType){
        this.userReaderPassportType = userReaderPassportType;
    }

    public String getUserReaderPassportType(){
        return userReaderPassportType;
    }

}