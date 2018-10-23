package pl.edu.agh.student.zyngier;

public class Polibiusz implements Algorithm {

    @Override
    public String crypt(String to_crypt) {
        int first_el=0, second_el=0, asci_id;
        String crypted="", tmp="";
        String new_text="";

        to_crypt = to_crypt.toLowerCase();

        for(int i=0; i<to_crypt.length(); i++){
            if(to_crypt.charAt(i) > 64 && to_crypt.charAt(i) < 91) new_text += (char)(((int)to_crypt.charAt(i)) + 32);
            else new_text += to_crypt.charAt(i);

            if(new_text.charAt(i) != ' ') {
                if ((int) new_text.charAt(i) - 97 > 8)
                    asci_id = (int)new_text.charAt(i) - 98;
                else
                    asci_id = (int)new_text.charAt(i) - 97;

                first_el = (asci_id / 5) + 1;

                second_el = (asci_id + 1) % 5;
                second_el = (second_el == 0) ? 5 : (asci_id + 1) % 5;

                tmp = Integer.toString(first_el);
                crypted+=tmp;
                tmp = Integer.toString(second_el);
                crypted+=tmp;
            }
        }

        return crypted;
    }

    @Override
    public String decrypt(String to_decrypt) {
        char[][] codes = new char[5][5];

        int count = 0;
        String alphabet = "abcdefghiklmnopqrstuvwxyz";
        String encrypted = "";

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                codes[i][j] = (char)alphabet.charAt(count);
                count++;
            }
        }

        for(int i=0; i<to_decrypt.length(); i+=2){
            encrypted += codes[((int)to_decrypt.charAt(i))-49][((int)to_decrypt.charAt(i+1))-49];
        }

        return encrypted;
    }
}