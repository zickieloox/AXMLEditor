package com.softsec.editor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.softsec.editor.decode.AXMLDoc;

public class Main {
	public static void change(String inputFile, String outputFile, String newPackageName, String newAppLabel) {
		try{
			AXMLDoc doc = new AXMLDoc();
			doc.parse(new FileInputStream(inputFile));
			doc.print();

			ChannelEditor editor = new ChannelEditor(doc);
			editor.commit(newPackageName, newAppLabel);
			doc.print();
			doc.build(new FileOutputStream(outputFile));

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		change("/sdcard/z.xml", "/sdcard/z.xml", "com.zic.test", "");
	}
}
