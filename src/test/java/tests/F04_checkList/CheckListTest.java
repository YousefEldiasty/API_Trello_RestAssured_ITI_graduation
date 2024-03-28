package tests.F04_checkList;

import org.testng.annotations.Test;
import tests.F01_board.T01_CreateBoardTest;
import tests.F01_board.T04_DeleteBoardTest;
import tests.F02_list.T05_CreateListTest;
import tests.F03_card.CardTest;
import tests.F03_card.T09_CreateCardTest;
import tests.F03_card.T10_DeleteCardTest;
import tests.base.BaseTest;

import static tests.F01_board.BoardTest.boardID;
import static tests.F02_list.ListTest.listID;
import static tests.F03_card.CardTest.cardID;

public class CheckListTest extends BaseTest {
    public static String checkListID;

    @Test(priority = 1)
    public void testCreateBoard(){boardID = T01_CreateBoardTest.testCreateBoard();
    }

    @Test(priority = 2)
    public void testCreateList(){listID = T05_CreateListTest.testCreateList();}

    @Test(priority = 3)
    public void createCard(){cardID = T09_CreateCardTest.testCreateCard();}

    @Test(priority = 4)
    public void createCheckList(){
        checkListID = T11_CreateCheckListTest.testCreateCheckList();
    }
    @Test(priority = 5)
    public void deleteCheckList(){
        T12_DeleteCheckListTest.testDeleteChecklist(checkListID);
    }
    @Test(priority = 6)
    public void deleteCard(){
        T10_DeleteCardTest.testDeleteCard(cardID);
    }

    @Test(priority = 7)
    public void testDeleteBoard(){
        T04_DeleteBoardTest.testDeleteBoard(boardID);
    }

}
