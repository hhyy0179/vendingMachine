import java.io.IOException;
import java.util.Scanner;

public class Controller {
    Help help = new Help();
    Client client = new Client();
    Admin admin = new Admin();
    Buy buy = new Buy();
    Change change = new Change();
    List list = new List();
    Quit quit = new Quit();

    public List getList(){
        return this.list;
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        String tempCmd;
        System.out.println("[Vending Machine]");
        System.out.printf("< 현재 금액 : %d >\n", client.currentAmount);
        tempCmd = scan.nextLine();
        String [] cmd = tempCmd.strip().split(" ");
        if(checkInputGrammar(cmd)){
            this.showMenu(cmd[0]);
        }
    }

    public boolean checkInputGrammar(String [] cmd){
        return true;
    }

    public void showMenu(String cmd) throws IOException {
        if(cmd == "help" || cmd =="he" || cmd == "?"){
            help.start();
        }
        else if(cmd == "list" || cmd =="li" || cmd =="ls" || cmd=="l"){
            list.start();
        }
        else if(cmd =="buy") {
        }
        else if(cmd =="depos") {
            client.calAmount(0);
        }
        else if(cmd =="change") {
        }
        else if(cmd =="admin") {
            admin.start();
        }
        else if(cmd =="quit") {
        }
        else {
        }
    }
}