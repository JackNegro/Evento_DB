package Utils;

public class Validation {
    public static boolean userAliasValidation(String user_alias) {
        return user_alias.matches("[A-Za-z0-9]+") && user_alias.length() <= 15;
    }

    public static boolean alphaBetaValidation(String alphaBeta) {
        return alphaBeta.matches("[A-Za-z]+") && alphaBeta.length() <= 15;
    }
    public static boolean isAlpha(String s){
        boolean bool = true;

        if(s != null)
            for(int i = 0; i < s.length() && bool == true; i++){
                char c = s.charAt(i);
                if(!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z'))
                    bool = false;
            }
        else
            bool = false;

        return bool;
    }

}
