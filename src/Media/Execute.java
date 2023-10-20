package Media;

import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        MediaFactory filmFactory = createMediaByForm("Film");
        Media film = filmFactory.createMedia();
        Media serial = filmFactory.createMedia();

        film.setName("Inception1");
        serial.setName("Inception2");

        clientPart();
    }

    public static void clientPart(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose \n1.Admin \n2.User ");
        int answer1 = scanner.nextInt();

        // ADMIN
        if(answer1 == 1){
            System.out.println("Add or Delete from list ");
            System.out.println("Press 1 if Add, \n0 if Delete");
            int answer2 = scanner.nextInt();
            System.out.println("What type of media, type <Film> or <Serial>");
            String answer3 = scanner.next();
            System.out.println("Write name of " + answer3 + ": ");
            String answer4 = scanner.next();

            if(answer2 == 1){
                MediaFactory mediaFactory = createMediaByForm(answer3);
                Media media = mediaFactory.createMedia();
                media.setName(answer4);
            }else if(answer2 == 0){
                if(answer3 == "Film"){

                }else{

                }
            }
        }

        // CLIENT
        else if (answer1 == 2){
            System.out.println("What would you like to do?");

        }
    }


    public static MediaFactory createMediaByForm(String Form){
        if(Form.equals("Film")){
            return new FilmFactory();
        } else if(Form.equals("Serial")){
            return new SerialFactory();
        } else{
            throw new RuntimeException(Form + " does not exist");
        }

    }
}
