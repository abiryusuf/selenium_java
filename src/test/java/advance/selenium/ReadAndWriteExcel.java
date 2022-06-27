package advance.selenium;

public class ReadAndWriteExcel {

    // PYTHON

//    import xlrd
//
//    workbook = xlrd.open_workbook("DataFile.xls")
//    sheet = workbook.sheet_by_name("UserCredentials")
//
//  # Get number of rows with data in excel sheet
//   rowcount = sheet.nrows
//# Get number of columns with data in each row. Returns highest number
//     colcount = sheet.ncols
//    print(rowcount)
//    print(colcount)
//
//    result_data =[]
//            for curr_row in range(1, rowcount, 1):
//    row_data = []
//
//            for curr_col in range(1, colcount-1, 1):
//            # Read the data in the current cell
//            data = sheet.cell_value(curr_row, curr_col)
//    print(data)
//        row_data.append(data)
//
//            result_data.append(row_data)

//    public static void main (String [] args) throws IOException {
//        //I have placed an excel file 'Test.xlsx' in my D Driver
//        FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
//        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
//        System.out.println(cell);
//        System.out.println(sheet.getRow(0).getCell(0));
//        //String cellval = cell.getStringCellValue();
//        //System.out.println(cellval);
//
//    }

    //JAVA

public void WriteExcel(){
    //create an object of Workbook and pass the FileInputStream object into it to create a pipeline between the sheet and eclipse.
//    FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
//    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//    //call the getSheet() method of Workbook and pass the Sheet Name here.
//    //In this case I have given the sheet name as “TestData”
//    //or if you use the method getSheetAt(), you can pass sheet number starting from 0. Index starts with 0.
//    XSSFSheet sheet = workbook.getSheet("TestData");
//    //XSSFSheet sheet = workbook.getSheetAt(0);
//    //Now create a row number and a cell where we want to enter a value.
//    //Here im about to write my test data in the cell B2. It reads Column B as 1 and Row 2 as 1. Column and Row values start from 0.
//    //The below line of code will search for row number 2 and column number 2 (i.e., B) and will create a space.
//    //The createCell() method is present inside Row class.
//    Row row = sheet.createRow(1);
//    Cell cell = row.createCell(1);
//    //Now we need to find out the type of the value we want to enter.
//    //If it is a string, we need to set the cell type as string
//    //if it is numeric, we need to set the cell type as number
//    cell.setCellType(cell.CELL_TYPE_STRING);
//    cell.setCellValue("SoftwareTestingMaterial.com");
//    FileOutputStream fos = new FileOutputStream("D:\\Test.xlsx");
//    workbook.write(fos);
//    fos.close();
//    System.out.println("END OF WRITING DATA IN EXCEL");
}
}


