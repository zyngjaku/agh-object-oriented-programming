package pl.edu.agh.student.zyngier;

public class ROT11 implements Algorithm {
    static char [] alphabet = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u','v', 'w', 'x', 'y', 'z'};

    @Override
    public String crypt(String to_crypt) {
        String crypted = "";
        to_crypt = to_crypt.toLowerCase();
        boolean match = false;
        for(int i=0; i<to_crypt.length(); i++){
            for(int j = 0; j< alphabet.length; j++){
                if (alphabet[j] == to_crypt.charAt(i)){
                    crypted += alphabet[(j+11)% alphabet.length];
                    match = true;
                }
            }
            if(match == false)
                crypted += to_crypt.charAt(i);
            match = false;
        }

        return crypted;
    }

    @Override
    public String decrypt(String to_decrypt) {
        String decrypted = "";
        to_decrypt = to_decrypt.toLowerCase();
        boolean match = false;

        for(int i=0; i<to_decrypt.length(); i++){
            for(int j = 0; j< alphabet.length; j++){
                if (alphabet[j] == to_decrypt.charAt(i)){
                    decrypted += alphabet[(j+15)% alphabet.length];
                    match = true;
                }
            }
            if(match == false)
                decrypted += to_decrypt.charAt(i);
            match = false;
        }
        return decrypted;
    }

}