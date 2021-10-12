import java.util.Scanner;

public class Help {
    Client client = new Client();

    public void start(){
        Scanner scan = new Scanner(System.in);
        String tempCmd;
        System.out.println("[Vending Machine]");
        System.out.printf("< 현재 금액 : %d >\n", client.currentAmount);
        tempCmd = scan.nextLine();
        String [] cmd = tempCmd.strip().split(" ");
        System.out.printf("length: %d", cmd.length);
    }

    public int checkInputGrammar(String [] cmd){


        return 0;
    }

    public void showMenu(String cmd){
        if(cmd == "help" || cmd =="he" || cmd == "?"){

        }
        else if(cmd == "list" || cmd =="li" || cmd =="ls" || cmd=="l"){

        }
        else if(cmd =="buy") {
        }
        else if(cmd =="depos") {
            client.calAmount(0);
        }
        else if(cmd =="change") {
        }
        else if(cmd =="admin") {
        }
        else if(cmd =="quit") {
        }
        else {
        }
    }
}
