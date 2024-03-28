package tests.F05_checkItem;

import org.testng.annotations.Test;
import tests.F01_board.T01_CreateBoardTest;
import tests.F01_board.T04_DeleteBoardTest;
import tests.F02_list.T05_CreateListTest;
import tests.F03_card.T09_CreateCardTest;
import tests.F03_card.T10_DeleteCardTest;
import tests.F04_checkList.T11_CreateCheckListTest;
import tests.F04_checkList.T12_DeleteCheckListTest;
import tests.base.BaseTest;

import static tests.F01_board.BoardTest.boardID;
import static tests.F02_list.ListTest.listID;
import static tests.F03_card.CardTest.cardID;
import static tests.F04_checkList.CheckListTest.checkListID;

public class CheckItemTest extends BaseTest {
    public static String checkItemID;

    @Test(priority = 1)
    public void testCreateBoard(){boardID = T01_CreateBoardTest.testCreateBoard();
    }

    @Test(priority = 2)
    public void testCreateList(){listID = T05_CreateListTest.testCreateList();}

    @Test(priority = 3)
    public void createCard(){cardID = T09_CreateCardTest.testCreateCard();}

    @Test(priority = 4)
    public void createCheckList(){checkListID = T11_CreateCheckListTest.testCreateCheckList();}

    @Test(priority = 5)
    public void createCheckItem(){checkItemID = T13_CreateCheckItem.testCreateCheckitem();}

    @Test(priority = 6)
    public void getCheckItem(){T14_GetCheckItemTest.testGetCheckItem();}

    @Test(priority = 7)
    public void deleteCheckItem(){T15_DeleteCheckItem.testDeleteCheckItem(checkItemID);}

    @Test(priority = 8)
    public void deleteCheckList(){T12_DeleteCheckListTest.testDeleteChecklist(checkListID);}

    @Test(priority = 9)
    public void deleteCard(){T10_DeleteCardTest.testDeleteCard(cardID);}

    @Test(priority = 10)
    public void testDeleteBoard(){T04_DeleteBoardTest.testDeleteBoard(boardID);}
}
