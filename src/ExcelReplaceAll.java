import java.io.File;
import java.io.FilenameFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.util.Properties;

public class ExcelReplaceAll{
    private Properties prop;

    public ExcelReplaceAll(String ini) throws Exception{
        try {
            this.prop = new java.util.Properties();
            prop.load(new java.io.FileInputStream(ini));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute() throws Exception{
        File input = new File(this.prop.getProperty("input-directory"));
        File output = new File(this.prop.getProperty("output-directory"));
        for(File file : input.listFiles(this.getXlsFilter())){
            this.modify(file.getAbsolutePath(), output + "/" + file.getName());
        }
    }

    public void modify(String input_file, String output_file) throws Exception{
        POIFSFileSystem filein = new POIFSFileSystem(new FileInputStream(input_file));
        HSSFWorkbook wb = new HSSFWorkbook(filein);

        for(int i = 0; i < wb.getNumberOfSheets(); i++){
            HSSFSheet sheet = wb.getSheetAt(i);
            for(int row = sheet.getFirstRowNum(); row < sheet.getLastRowNum(); row++){
                if(sheet.getRow(row) == null) continue;
                for(int col = sheet.getRow(row).getFirstCellNum(); col < sheet.getRow(row).getLastCellNum(); col++){
                    if(sheet.getRow(row).getCell(col) == null) continue;
                    for (String propertyName : this.prop.stringPropertyNames()) {
                        if(sheet.getRow(row).getCell(col).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            if(sheet.getRow(row).getCell(col).getNumericCellValue() == Double.parseDouble(propertyName)){
                                sheet.getRow(row).getCell(col).setCellValue(prop.getProperty(propertyName));
                            }
                        } else {
                            if(sheet.getRow(row).getCell(col).getStringCellValue().matches(".*" + propertyName + ".*")){
                                sheet.getRow(row).getCell(col).setCellValue(sheet.getRow(row).getCell(col).getStringCellValue().replaceAll(propertyName, prop.getProperty(propertyName)));
                            }
                        }
                    }
                }
            }
        }
        wb.write(new FileOutputStream(output_file));
    }

    private FilenameFilter getXlsFilter() {
        return new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches(".*\\.xls");
            }
        };
    }
}
