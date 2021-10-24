package vm;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	 // 시작 할 때 메모리에 올릴 것
    	List.readList();
        Controller.setCmdList();
        Admin.setAdminCmdList();
      //1.명령어 입력받기
        Controller controller = new Controller();
        controller.run();
        
    }
}