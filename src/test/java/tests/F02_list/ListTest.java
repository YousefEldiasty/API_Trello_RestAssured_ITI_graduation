package tests.F02_list;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.F01_board.T01_CreateBoardTest;
import tests.F01_board.T04_DeleteBoardTest;

import static io.restassured.RestAssured.given;

import static tests.F01_board.BoardTest.boardID;


public class ListTest extends BaseTest {
    public static String board2ID;
    public static String listID;

    @Test(priority = 1)
    public void testCreateBoard(){
        boardID = T01_CreateBoardTest.testCreateBoard();
    }

    @Test(priority = 2)
    public void createList(){
        listID = T05_CreateListTest.testCreateList();
    }

    @Test(priority = 3)
    public void getList(){
        T06_GetListTest.testGetListFromBoard();
    }

    @Test(priority = 4)
    public void updateList(){
        T07_UpdateListTest.testUpdateList();
    }

    @Test(priority = 5)
    public void CreateBoard2(){
        board2ID = T01_CreateBoardTest.testCreateBoard();
    }

    @Test(priority = 6)
    public void moveList(){
        T08_MoveList.testMoveList();
    }

    @Test(priority = 7)
    public void deleteBoard1(){
        T04_DeleteBoardTest.testDeleteBoard(boardID);
    }

    @Test(priority = 8)
    public void deleteBoard2(){
        T04_DeleteBoardTest.testDeleteBoard(board2ID);
    }
}
