package tests.F01_board;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BoardTest extends BaseTest {
    public static String boardID;

    // Valid Create
    @Test(priority = 1)
    public void createBoard(){boardID = T01_CreateBoardTest.testCreateBoard();}
    // Create Invalid
    @Test(priority = 2)
    public void tokenInvalidCreate(){T01_CreateBoardTest.invalidTestCreateBoardWithoutToken();}
    @Test(priority = 2)
    public void blankNameInvalidCreate(){T01_CreateBoardTest.invalidTestCreateBoardWithBlankName();}
    @Test(priority = 2)
    public void LongNameInvalidCreate(){T01_CreateBoardTest.invalidTestCreateBoardWithLongName();}

    // Valid Get
    @Test(priority = 3)
    public void getBoard(){T02_GetBoardTest.testGetBoard(boardID);}
  // Invalid Get
    @Test(priority = 4)
    public void blankIdInvalidGet(){T02_GetBoardTest.invalidTestGetBoardWithoutName("");}
    @Test(priority = 4)
    public void PostInvalidGet(){T02_GetBoardTest.invalidTestGetBoardWithPost(boardID);}

    // Update
    @Test(priority = 5)
    public void updateBoard(){T03_UpdateBoardTest.testUpdateBoard();}

    // Delete
    @Test(priority = 6)
    public void deleteBoard(){T04_DeleteBoardTest.testDeleteBoard(boardID);}
}
