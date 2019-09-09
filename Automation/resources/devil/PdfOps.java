package devil;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfImageObject;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class PdfOps {
	public static float FACTOR = 1.0f;
	public static void convert(String path, String filename, String imageExtension) {
		try {
			
			File root = new File(path);
			int count = fileCountWithExtension(root, imageExtension);
			List<String> files = new ArrayList<String>();
	        for(int i = 0; i<count;i++) { files.add((i + 1) + imageExtension);}
	        
	        Document document = getDocument(path, files.get(0));	        
	        PdfWriter writer = PdfWriter.getInstance(document, 
	        		new FileOutputStream(new File(root, filename + ".pdf")));
	        document.open();
	        
	        Image image;
	        Rectangle rectangle;
	        for (String f : files) {
	        	writer.setCompressionLevel(50);
	        	image = Image.getInstance(new File(root, f).getAbsolutePath());
	        	rectangle = new Rectangle(image.getWidth(),image.getHeight());
	            //image.scaleToFit(image.getWidth(), image.getHeight());
				document.add(image);
	            document.setPageSize(rectangle);
	        }
	        document.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	public static Document getDocument(String path, String file) {
		Document document = null;
		try {
		Image i = Image.getInstance(new File(path, file).getAbsolutePath());
        Rectangle p = new Rectangle(i.getWidth(),i.getHeight());
        document = new Document(p);
        document.setMargins(0, 0, 0, 0);
		}catch(Exception e) {
			e.printStackTrace();
		}
        return document;
	}
	public static int fileCountWithExtension(File root, String extension) {
		int count = 0;
		for (File file : root.listFiles()) {
		if (file.isFile() && (file.getName().endsWith(extension))) { 
			  count++; 
			} 
		}
		return count;
	}
	public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
	    //PdfName key = new PdfName("ITXT_SpecialId");
	    //PdfName value = new PdfName("123456789");
	    // Read the file
	    PdfReader reader = new PdfReader(src);
	    //int n = reader.getXrefSize();
	    PdfObject object;
	    PRStream stream;
	    // Look for image and manipulate image stream
	    for (int i = 0; i < reader.getXrefSize(); i++) {
	        object = reader.getPdfObject(i);
	        if (object == null || !object.isStream())
	            continue;
	        stream = (PRStream)object;
	       // if (value.equals(stream.get(key))) {
	        PdfObject pdfsubtype = stream.get(PdfName.SUBTYPE);
	        //System.out.println(stream.type());
	        if (pdfsubtype != null && pdfsubtype.toString().equals(PdfName.IMAGE.toString())) {
	            PdfImageObject image = new PdfImageObject(stream);
	            BufferedImage bi = image.getBufferedImage();
	            if (bi == null) continue;
	            int width = (int)(bi.getWidth() * FACTOR);
	            int height = (int)(bi.getHeight() * FACTOR);
	            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	            AffineTransform at = AffineTransform.getScaleInstance(FACTOR, FACTOR);
	            Graphics2D g = img.createGraphics();
	            g.drawRenderedImage(bi, at);
	            ByteArrayOutputStream imgBytes = new ByteArrayOutputStream();
	            ImageIO.write(img, "JPG", imgBytes);
	            stream.clear();
	            stream.setData(imgBytes.toByteArray(), false, PRStream.BEST_COMPRESSION);
	            stream.put(PdfName.TYPE, PdfName.XOBJECT);
	            stream.put(PdfName.SUBTYPE, PdfName.IMAGE);
	            stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
	            stream.put(PdfName.FILTER, PdfName.DCTDECODE);
	            stream.put(PdfName.WIDTH, new PdfNumber(width));
	            stream.put(PdfName.HEIGHT, new PdfNumber(height));
	            stream.put(PdfName.BITSPERCOMPONENT, new PdfNumber(8));
	            stream.put(PdfName.COLORSPACE, PdfName.DEVICERGB);
	        }
	    }
	    // Save altered PDF
	    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	    stamper.close();
	    reader.close();
	}
	
	public static void main(String[] args) throws IOException, DocumentException {
		//PdfOps.manipulatePdf("F:\\KAOS-Comics\\Doctor-Bitch\\Issue-1\\Issue-1.pdf", "F:\\KAOS-Comics\\Doctor-Bitch\\Issue-1\\Issue-1_1.pdf");
		System.out.println(PdfOps.fileCountWithExtension(new File("F:\\Learning"), ".jpg"));
		PdfOps.convert("F:\\Learning", "test", ".jpg");
	}
}