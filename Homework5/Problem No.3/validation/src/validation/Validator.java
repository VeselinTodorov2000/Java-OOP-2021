package validation;

public class Validator {
    public static boolean validateEmpty(String username, String phone, String email, String password, String passwordConfirm){
        return username.equals("") && phone.equals("") && email.equals("")
                && password.equals("") && passwordConfirm.equals("");
    }

    public static boolean validateUsername(String username){
        return username.matches("[a-zA-Z]{2,}");
    }

    public static boolean validatePhone(String phone){
        return phone.matches("[(][0-9]{4}[)][(][0-9]{7}[)]");
    }

    public static boolean validateEmail(String email){
        return email.matches("([a-z]+([.]|[a-z]*))+[@][a-z]+[.][a-z]+");
    }

    public static boolean validatePassword(String password){
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^*@&]).{5,}$");
    }

    public static boolean validateConfirmPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
}
