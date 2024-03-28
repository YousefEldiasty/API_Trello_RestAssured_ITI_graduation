package tests.F03_card;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.F01_board.T01_CreateBoardTest;
import tests.F01_board.T04_DeleteBoardTest;
import tests.F02_list.T05_CreateListTest;

import static io.restassured.RestAssured.given;
import static tests.F01_board.BoardTest.boardID;
import static tests.F02_list.ListTest.listID;


public class CardTest extends BaseTest {

    public static String cardID;

    @Test(priority = 1)
    public void testCreateBoard(){boardID = T01_CreateBoardTest.testCreateBoard();
    }

    @Test(priority = 2)
    public void testCreateList(){listID = T05_CreateListTest.testCreateList();}

    @Test(priority = 3)
    public void createCard(){cardID = T09_CreateCardTest.testCreateCard();}

    @Test(priority = 4)
    public void deleteCard(){
        T10_DeleteCardTest.testDeleteCard(cardID);
    }

    @Test(priority = 5)
    public void testDeleteBoard(){
        T04_DeleteBoardTest.testDeleteBoard(boardID);
    }

}
