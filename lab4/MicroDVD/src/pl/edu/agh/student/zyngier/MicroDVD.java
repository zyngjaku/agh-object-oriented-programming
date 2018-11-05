package pl.edu.agh.student.zyngier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MicroDVD {

    public static void delay(String input, String output, int delay, int fps) throws BadFormatException{
        File file = new File(input);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String get_line = scanner.nextLine();
                boolean start=false, end=false;
                int time_start=0, time_end=0;
                String text="";

                for(int i=0; i<get_line.length(); i++){
                    String tmp="";
                    char get_char = get_line.charAt(i);
                    if(get_char == '{'){

                        for(int j=i+1; j<get_line.length(); j++){
                            if(get_line.charAt(j) == '}'){
                                i=j;
                                break;
                            }

                            tmp+=get_line.charAt(j);
                        }

                        if(tmp!=""){
                            if(isInteger(tmp)) {
                            	if(!start) {
                            		time_start = Integer.valueOf(tmp);
                            		start=true;
                            	}
                            	else if(!end) {
                            		time_end = Integer.valueOf(tmp);
                            		end=true;

                            		if(time_end<time_start)
                                    	throw new BadFormatException(get_line);
                            	}
                            }
                            else {
                            	throw new BadFormatException(get_line);
                            }

                            start = true;
                            
                        }
                        else{
                        	throw new BadFormatException(get_line);
                        }


                    }
                    else {
                    	while(i<get_line.length()) {
                            tmp+=get_line.charAt(i);
                            i++;
                    	}
                    	
                    	double mspf = 1000 / (double)45;
                        int przesuniecie = (int)(delay/mspf);
                    	
                    	System.out.println("{"+(time_start+przesuniecie)+"}{"+(time_end+przesuniecie)+"}"+tmp);    	
                    	
                    }

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    public static boolean isInteger(String checking_string) {
    	for(int i=0; i<checking_string.length(); i++) {
        	if((int)checking_string.charAt(i)<48 || (int)checking_string.charAt(i)>57)
        		return false;
        }
		
    	return true;
    }

}
