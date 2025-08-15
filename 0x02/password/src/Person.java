public class Person {

    public boolean checkUser(String username) {
        if (username == null || username.length() < 8) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9]+$");
    }

    public boolean checkPassword(String password){
        if(password == null || password.length() < 8){
            return false;
        }

        char ch;
        boolean capitalFlag = false;
        boolean specialChar = false;
        boolean numberFlag = false;

        for(int i=0; i < password.length(); i++) {
            ch = password.charAt(i);
            if(Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if(Character.isUpperCase(ch)) {
                capitalFlag = true;
            }
            else if(!Character.isLetter(ch) && !Character.isDigit(ch)) {
                specialChar = true;
            }
        }

        if(capitalFlag && specialChar && numberFlag){
            return true;
        }
        return false;
    }
}
