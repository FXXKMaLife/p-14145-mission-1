import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App { //기능구현
    //입력받기

    void run(){

        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);//Scanner객체 생성

        ArrayList<Quote> list = new ArrayList<>();//List생성
        int count = 0;//반복횟수를 저장하기 위한 변수

        outer:
        while (true) {//참인 동안 반복
            System.out.print("명령) ");
            String str = sc.nextLine().trim();//명령입력

            if (str.startsWith("삭제?id=")) {//삭제 기능 구현
                int deleteId = Integer.parseInt(str.split("=")[1]);//형변환

                Iterator<Quote> iterator = list.iterator();
                boolean deleted = false;

                while (iterator.hasNext()) {
                    Quote q = iterator.next();
                    if (q.id == deleteId) {
                        iterator.remove();
                        deleted = true;
                        break;
                    }
                }

                if (deleted) {
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", deleteId);
                } else {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", deleteId);
                }


            } else if (str.startsWith("수정?id=")) {//수정기능
                int editId = Integer.parseInt(str.split("=")[1]); // =를 기준으로 id 추출

                // id에 해당하는 명언 객체 탐색
                Quote target = null; // 찾으면 여기에 저장, 못 찾으면 null 유지
                for (Quote q : list) {
                    if (q.id == editId) {
                        target = q; // 참조값 저장 (같은 객체를 가리킴)
                        break;
                    }
                }

                if (target == null) {
                    // 존재하지 않는 id일 경우
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", editId);
                } else {
                    // 기존값 출력 후 새 값 입력받기
                    System.out.printf("명언(기존) : %s\n", target.quote);
                    System.out.print("명언 : ");
                    String newQuote = sc.nextLine();

                    System.out.printf("작가(기존) : %s\n", target.author);
                    System.out.print("작가 : ");
                    String newAuthor = sc.nextLine();


                    target.quote = newQuote;
                    target.author = newAuthor;
                }

            } else {
                switch (str) {//명령어 구분
                    case "등록":
                        System.out.print("명언 : ");
                        String quote = sc.nextLine();

                        System.out.print("작가 : ");
                        String author = sc.nextLine();

                        count++;
                        list.add(new Quote(quote, author, count));
                        System.out.printf("%d번 명언이 등록되었습니다.\n", count);
                        break;

                    case "목록":
                        System.out.println("번호 / 작가 / 명언");
                        System.out.println("----------------------");
                        for (int i = list.size() - 1; i >= 0; i--) {
                            Quote q = list.get(i);
                            System.out.printf("%d / %s / %s\n", q.id, q.author, q.quote);
                        }
                        break;

                    case "종료":
                        break outer;
                }
            }
        }


    }
}


