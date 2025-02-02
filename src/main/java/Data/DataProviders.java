package Data;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public static String[][] getAlldata() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//UsersData.xlsx";
        XLUtilities xl = new XLUtilities(path);

        int rownum = xl.getRowCount("sheet1");
        int colcount = xl.getCellCount("sheet1", 1);

        String apidata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j <= colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("sheet1", i, j);
            }
        }
        return apidata;
    }
}
