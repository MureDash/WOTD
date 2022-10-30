import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class HTMLUtil{

static TimerTask url(){

  URLConnection conn;
  URL webPage;
  try{

  webPage = new URL("https://www.merriam-webster.com/word-of-the-day");
  conn = webPage.openConnection();
  InputStreamReader input = new InputStreamReader(conn.getInputStream(), "UTF8");

  BufferedReader br = new BufferedReader(input);
  test t1 = new test();
  t1.test1 = true;
  HTMLfilter(br);


  }
  catch (MalformedURLException e){
    e.printStackTrace();
  }
  catch(IOException e){
    e.printStackTrace();
  }
  return null;
}

/**
 * @param reader
 * @throws IOException
 */
static void HTMLfilter(BufferedReader reader) throws IOException{
  String line = " ";

  FileWriter myWriter = new FileWriter("t.txt");

  while(true){
    line = reader.readLine();
    if(line !=null){
      line = line.replaceAll(":<style.+?>.+?</style>|<script.+?>.+?</script>|<(?:!|/?[a-zA-Z]+).*?/?>", " ");
      line = line.replaceAll("\\s+", " ");
      myWriter.write(line);
      test t2 = new test();
      t2.test2 = true;
      filereader();
      
    }
    
    else{
      myWriter.close();
      break;
    }
  }

}



  static void filereader() {
    try{
      String text = "";
      text = new String(Files.readAllBytes(Paths.get("t.txt")));
      text = text.substring(6579,7003);
      text = text.replaceAll("\\s+"," ");
      StringBuilder sb = new StringBuilder(text);
      sb.delete(50, 110);
      sb.delete(289, 320);
      text = sb.toString();
      /*       text = text.replace("play adjective fru gal", "");
      text = text.replace(" --> pih-KYOOL-yer ", "");
      text = text.replace("pih-KYOOL-yer", "");
      text = text.replace("--> Prev Next", ""); */

     
      // 51, 97
      // System.out.println(text);
      test t3 = new test();
      t3.test3 = true;
      generateNewFiles(text);
    } catch(Exception e){
      e.printStackTrace();
    }

}

static void generateNewFiles(String y){
  try{ 
  FileWriter writer = new FileWriter("newWOTD.txt");
  writer.write(y);
  writer.close();
  test t4 = new test();
  t4.test4 = true;

  }catch(Exception e){
    e.printStackTrace();
  };
}




// On a permanent fixed timer (schedular)



  public final static void main(String[] args) throws Exception{
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(url(), 0, 86400000);


    test overallTest = new test();
  if(overallTest.test1 == true){
    System.out.println("Test 1 Passed");
  }
  else{
    System.out.println("Test 1 Failed");
  }

  if(overallTest.test2 == true){
    System.out.println("Test 2 Passed");
  }

  else{
    System.out.println("Test 2 Failed");
  }

  if(overallTest.test3 == true){
    System.out.println("Test 3 Passed");
  }
  else{
    System.out.println("Test 3 Failed");
  }
  if(overallTest.test4 == true){
    System.out.println("Test 4 Passed");
  }
  else{
    System.out.println("Test 4 Failed");
  }





  
   


    
  
    }

 

    
  }

