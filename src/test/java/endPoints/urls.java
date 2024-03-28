package endPoints;

public class urls {
    //base URL
    public static String baseUrl = "https://api.trello.com";

    //Board
    public static String createBoard = "/1/boards/";
    public static String getUpdateDelete_board = "/1/boards/{id}";

    //List
    public static String createList = "/1/boards/{board_1_id}/lists";
    public static String getUpdateList = "/lists/{list_id}";
    public static String moveList = "lists/{list_id}/idBoard";

    //Cards
    public static String createCard = "/1/cards";
    public static String deleteCard = "/1/cards/{card_id}";

    //CheckList
    public static String createCheckList = "/1/checklists";
    public static String deleteCheckList = "/1/checklists/{checkList_id}";

    //CheckItem
    public static String createCheckItem = "/1/checklists/{checkList_id}/checkItems";
    public static String getDeleteCheckItem = "/1/checklists/{checkList_id}/checkItems/{checkItem_id}";

}
