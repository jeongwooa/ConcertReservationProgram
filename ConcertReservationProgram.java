package ConcertReservation_9;

import java.util.Scanner;

public class ConcertReservationProgram
{
    //TODO: 좌석예매 함수 S, A, B가 중복성이 있어서 제거할 필요가 있음
    //TODO: 이미 좌석이 예매되어있는 경우 예외처리 필요, 취소할때도 마찬가지

    static void run()
    {
        LineS[] lineS = new LineS[10];
        LineA[] lineA = new LineA[10];
        LineB[] lineB = new LineB[10];
        String[] strings = new String[10];

        int select;
        Scanner sc = new Scanner(System.in);



        MakeAllLineArray(lineS, lineA, lineB); // 각 열들의 10개의 좌석 배열객체 생성
        System.out.println("명품콘서트홀 예약 시스템입니다.");

        while (true)
        {
            select = selectNum(sc); // 기능 선택 함수

            switch (select)
            {
                case 1:
                {
                    reservation(lineS, lineA, lineB, sc); // 예약함수
                    break;
                }
                case 2:
                {
                    printAllSeat(lineS, lineA, lineB); // 모든 좌석 현황출력
                    break;
                }
                case 3:
                {
                    deleteSeat(lineS, lineA, lineB, sc); // 좌석 예매 취소 함수
                    break;
                }
                case 4: // 프로그램 종료
                {
                    System.out.println("프로그램 종료");
                    sc.close();
                    System.exit(0); // 정상 종료
                }

            }

        }
    }




    private static void deleteSeat(LineS[] lineS, LineA[] lineA, LineB[] lineB, Scanner sc) // 예매 취소 함수
    {
        String name;
        int seat;
        System.out.print("좌석 S(1)  A(2)  B(3) >>");
        seat = sc.nextInt();
        sc.nextLine();

        if (seat == 1)
        {

            showLineS(lineS);
            System.out.print("이름 >>");
            name = sc.nextLine();
            for (int i = 0; i < lineS.length; i++)
            {
                if(lineS[i].getName().equalsIgnoreCase(name))
                {
                    lineS[i].setName("---");
                    break;
                }
                if (i == lineA.length - 1) System.out.println("존재하지 않습니다.");


            }
        }
        else if (seat == 2)
        {
            showLineA(lineA);
            System.out.print("이름 >>");
            name = sc.nextLine();
            for (int i = 0; i < lineA.length; i++)
            {
                if(lineA[i].getName().equalsIgnoreCase(name))
                {
                    lineA[i].setName("---");
                    break;
                }

                if (i == lineA.length - 1) System.out.println("존재하지 않습니다.");
            }
        }
        else if (seat == 3)
        {
            showLineB(lineB);
            System.out.print("이름 >>");
            name = sc.nextLine();
            for (int i = 0; i < lineA.length; i++)
            {
                if(lineA[i].getName().equalsIgnoreCase(name))
                {
                    lineA[i].setName("---");
                    break;
                }

                if (i == lineA.length - 1) System.out.println("존재하지 않습니다.");


            }
        }
        else
        {
            System.out.println("존재하지 않는 번호입니다.");
        }

    }



    private static void printAllSeat(LineS[] lineS, LineA[] lineA, LineB[] lineB) // 모든 좌석 현황출력
    {
        System.out.println("<<<조회를 시작합니다.>>>");
        System.out.print("S>> ");
        for (int i = 0; i < lineS.length; i++)
            System.out.print(lineS[i].getName() + " ");
        System.out.println();


        System.out.print("A>> ");
        for (int i = 0; i < lineA.length; i++)
            System.out.print(lineA[i].getName() + " ");
        System.out.println();

        System.out.print("B>> ");
        for (int i = 0; i < lineB.length; i++)
            System.out.print(lineB[i].getName() + " ");
        System.out.println();

        System.out.println("<<<조회를 완료하였습니다.>>>");

    }



    private static void reservation(LineS[] lineS, LineA[] lineA, LineB[] lineB, Scanner sc) // 예약기능함수구현
    {
        int select;
        System.out.print("좌석구분 S(1)  A(2)  B(3) >>");
        select = sc.nextInt();
        sc.nextLine();

        switch (select)
        {
            case 1:
            {
                showLineS(lineS); // S열 10개의 좌석목록
                reservationSeatLineS(lineS, sc); // S열 예매 시작
                break;
            }
            case 2:
            {
                showLineA(lineA); // A열 10개의 좌석목록
                reservationSeatLineA(lineA, sc); // A열 좌석 예매시작
                break;
            }
            case 3:
            {
                showLineB(lineB); // B열 10개의 좌석목록
                reservationSeatLineB(lineB, sc); // B열 예매시작
                break;
            }
            default:
            {
                System.out.println("잘못된 입력");
                break;
            }
        }

    }

    private static void showLineS(LineS[] lineS)
    {
        System.out.print("S>> ");
        for (int i = 0; i < lineS.length; i++)
            System.out.print(lineS[i].getName() + " ");

        System.out.println();
    }

    private static void showLineA(LineA[] lineA)
    {
        System.out.print("A>> ");
        for (int i = 0; i < lineA.length; i++)
            System.out.print(lineA[i].getName() + " ");

        System.out.println();
    }

    private static void showLineB(LineB[] lineB)
    {
        System.out.print("B>> ");
        for (int i = 0; i < lineB.length; i++)
            System.out.print(lineB[i].getName() + " ");

        System.out.println();
    }



    private static void reservationSeatLineS(LineS[] lineS , Scanner sc) // S라인 좌석 예매
    {
        System.out.print("이름 >>");
        String name = sc.nextLine();
        System.out.print("좌석 번호 (1 ~ 10) >>");
        int seatNumber = sc.nextInt();
        sc.nextLine();

        lineS[seatNumber-1].setName(name);
    }


    private static void reservationSeatLineA(LineA[] lineA, Scanner sc) // A라인 좌석 예매
    {
        System.out.print("이름 >>");
        String name = sc.nextLine();
        System.out.print("좌석 번호 (1 ~ 10) >>");
        int seatNumber = sc.nextInt();
        sc.nextLine();

        lineA[seatNumber-1].setName(name);

    }

    private static void reservationSeatLineB(LineB[] lineB, Scanner sc) // B라인 좌석 예매
    {
        System.out.print("이름 >>");
        String name = sc.nextLine();
        System.out.print("좌석 번호 (1 ~ 10) >>");
        int seatNumber = sc.nextInt();
        sc.nextLine();

        lineB[seatNumber-1].setName(name);

    }



    private static int selectNum(Scanner sc)  // 기능 선택
    {
        // TODO: 잘못된 번호입력 예외처리

        int select;
        System.out.print("예약(1) 조회(2) 예약취소(3) 종료(4) >>");
        select = sc.nextInt();
        sc.nextLine();
        return select;

    }




    private static void MakeAllLineArray(LineS[] lineS, LineA[] lineA, LineB[] lineB) // 객체 생성 및 초기화
    {

        for (int i = 0; i < 10; i++)
        {
            lineS[i] = new LineS("---");
            lineA[i] = new LineA("---");
            lineB[i] = new LineB("---");
        }
    }

}
