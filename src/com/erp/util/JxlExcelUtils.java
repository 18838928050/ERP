package com.erp.util;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxl.CellView;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/**
 * 
 * @author JiaQi
 * 返回的是excle 工作簿
 */
public class JxlExcelUtils {
    /**
     * 导出Excel
     * listContent 正文
     * sheetName sheet名字
     * keyMap 的value值,标题居中粗体显示
     * os 创建表的流
     */
    public WritableWorkbook getExcelStream(String sheetName,LinkedHashMap<String, String> keyMap, List listContent,
            OutputStream os, Map<String, String> methodMap) {
        int flag = 0;
        // 声明工作簿
        WritableWorkbook workbook;
        try {
            // 根据传进来的file对象创建可写入的Excel工作薄
            workbook = Workbook.createWorkbook(os);
            // 创建一个工作表
            WritableSheet ws = workbook.createSheet(sheetName, 0);

            SheetSettings ss = ws.getSettings();
            ss.setVerticalFreeze(1);// 冻结表头

            // 设置字体
            WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 12);
            WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD);

            // 标题居中
            WritableCellFormat titleFormat = new WritableCellFormat(BoldFont);
            titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
            titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
            titleFormat.setAlignment(Alignment.CENTRE); // 文字水平对齐
            titleFormat.setWrap(false); // 文字是否换行

            // 正文居中
            WritableCellFormat contentCenterFormat = new WritableCellFormat(NormalFont);
            contentCenterFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            contentCenterFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            contentCenterFormat.setAlignment(Alignment.CENTRE);
            contentCenterFormat.setWrap(false);

            // 正文右对齐
            WritableCellFormat contentRightFormat = new WritableCellFormat(NormalFont);
            contentRightFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            contentRightFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            contentRightFormat.setAlignment(Alignment.RIGHT);
            contentRightFormat.setWrap(false);

            // 设置标题,标题内容为keyMap中的value值,标题居中粗体显示
            Iterator titleIter = keyMap.entrySet().iterator();
            int titleIndex = 0;
            while (titleIter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) titleIter.next();
                ws.addCell(new Label(titleIndex++, 0, entry.getValue(),titleFormat));
            }

            // 设置正文内容
            for (int i = 0; i < listContent.size(); i++) {
                Iterator contentIter = keyMap.entrySet().iterator();
                int colIndex = 0;
                while (contentIter.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) contentIter.next();
                    String key = entry.getKey().toString();
                    Field field = listContent.get(i).getClass().getDeclaredField(key);
                    field.setAccessible(true);
                    Object content = field.get(listContent.get(i));
                    String value = "";
                    if (null != content) {
                        value = content.toString();
                    }
                    if (methodMap != null) {
                        String methodName = methodMap.get(key);
                        if (methodName != null) {
                            Method convertMethod = this.getClass().getDeclaredMethod(methodName, String.class);
                            value = (String) convertMethod.invoke(this, value);
                        }
                    }
                    ws.addCell(new Label(colIndex++, i + 1, value,contentCenterFormat));
                }
            }

            // 宽度自适应。能够根据内容增加宽度，但对中文的支持不好，如果内容中包含中文，会有部分内容被遮盖
            for (int i = 0; i < keyMap.size(); i++) {
                CellView cell = ws.getColumnView(i);
                cell.setAutosize(true);
                ws.setColumnView(i, cell);
            }

            // 写入Exel工作表
            workbook.write();

            // 关闭Excel工作薄对象
            workbook.close();

            // 关闭流
            os.flush();
            os.close();
            os = null;
            
            return workbook;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            flag = 0;
            ex.printStackTrace();
        }
        return null;
    }
    
//    		  使用说明
    
    
//            List<Card> list = 获取数据集合;
//            LinkedHashMap<String, String> keyMap = new LinkedHashMap<String, String>();
//            keyMap.put("cardNo", "卡号");
//            keyMap.put("activationCode", "激活码");
//            keyMap.put("cardType", "卡类型");
//
//            Map<String,String> methodMap = new HashMap<String,String>();
//            methodMap.put("cardType", "cardTypeConverter");
//            JxlExcelUtils util = new JxlExcelUtils();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//            if(list != null && list.size() > 0){
//                util.getExcelStream("智朗卡",keyMap, list,out,methodMap);
//                excelStream =  new ByteArrayInputStream(out.toByteArray());
//                fileName  = UUID.randomUUID().toString();
//            }          List<Card> list = 获取数据集合;
//            LinkedHashMap<String, String> keyMap = new LinkedHashMap<String, String>();
//            keyMap.put("cardNo", "卡号");
//            keyMap.put("activationCode", "激活码");
//            keyMap.put("cardType", "卡类型");
//
//            Map<String,String> methodMap = new HashMap<String,String>();
//            methodMap.put("cardType", "cardTypeConverter");
//            JxlExcelUtils util = new JxlExcelUtils();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//            if(list != null && list.size() > 0){
//                util.getExcelStream("智朗卡",keyMap, list,out,methodMap);
//                excelStream =  new ByteArrayInputStream(out.toByteArray());
//                fileName  = UUID.randomUUID().toString();
//            }
    
}