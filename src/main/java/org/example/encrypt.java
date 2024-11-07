package org.example;

public class encrypt {
    static String encryptAlpabet(String encryptKey){
        String alpabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder alpabetBuilder = new StringBuilder();

        int cyferIndex;
        for (int i = 0; i < encryptKey.length(); i++) {
            cyferIndex = encryptKey.charAt(i) - '0';
            if(cyferIndex >= 0 && cyferIndex <= 9){
                int index = alpabet.length() - cyferIndex;

                for (int j = 0; j < alpabet.length(); j++) {
                    alpabetBuilder.append(alpabet.charAt(index));
                    index++;
                    if(index == alpabet.length()) index = 0;
                }
                alpabet = alpabetBuilder.toString();
                alpabetBuilder = new StringBuilder();
            }
            else {
                int splitIndex = alpabet.indexOf(encryptKey.charAt(i));
                if(splitIndex != -1){
                    String sendBack = alpabet.substring(0, splitIndex);
                    String sendForward = alpabet.substring(splitIndex);

                    alpabetBuilder.append(sendForward);
                    alpabetBuilder.append(sendBack);

                    alpabet = alpabetBuilder.toString();
                    alpabetBuilder = new StringBuilder();
                }
            }
        }
        return alpabet;
    }
    public static String encryptString(String userString, String encryptKey){
        String alpabet = "abcdefghijklmnopqrstuvwxyz";
        String encryptedAlpabet = encryptAlpabet(encryptKey);

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < userString.length(); i++) {
            char curentChar = userString.charAt(i);
            int encryptIndex = alpabet.indexOf(curentChar);
            if(encryptIndex != -1){
                newString.append(encryptedAlpabet.charAt(encryptIndex));
            }
        }
        return newString.toString();
    }
    public static String decryptString(String userString, String encryptKey){
        String alpabet = "abcdefghijklmnopqrstuvwxyz";
        String encryptedAlpabet = encryptAlpabet(encryptKey);

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < userString.length(); i++) {
            char curentChar = userString.charAt(i);
            int encryptIndex = encryptedAlpabet.indexOf(curentChar);
            if(encryptIndex != -1){
                newString.append(alpabet.charAt(encryptIndex));
            }
        }
        return newString.toString();
    }
}
