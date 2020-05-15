package ShopRepositoryFile;

import Shop.Shop;
import ShopRepository.Repository;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepositoryFile {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://tiki.vn/thoi-trang-nam/c915?src=c.914.hamburger_menu_fly_out_banner");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern name = Pattern.compile("data-title=\"(.*?)\" data-price");
            Pattern price = Pattern.compile(" data-price=\"(.*?)\" data-id");
            Pattern id = Pattern.compile("a data-id=\"(.*?)\" href");
            Matcher Name = name.matcher(content);
            Matcher Price = price.matcher(content);
            Matcher ID = id.matcher(content);
            //GHI DỮ LIỆU VÀO FILE
            File file = new File("C:\\Users\\Admin\\IdeaProjects\\Text2\\BanThuCaySuTaDy\\src\\ShopRepositoryFile\\Shop.txt");
            FileWriter os = new FileWriter(file);
            BufferedWriter bff = new BufferedWriter(os);
            while (Name.find() && ID.find() && Price.find()) {
                String line = (
                        ID.group(1).replaceAll(",", "-")
                                + "," + Name.group(1).replaceAll(",",";")
                                + "," + Price.group(1).replaceAll("\"", ""));
                System.out.println(line);
                bff.write(line);
                bff.newLine();
            }
            bff.close();
            //ĐỌC FILE  TỪ DŨ LIỆU
            FileReader fileReader = new FileReader(new File("C:\\Users\\Admin\\IdeaProjects\\Text2\\BanThuCaySuTaDy\\src\\ShopRepositoryFile\\Shop.txt"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                System.out.println(
                        " Name:"+ split[0]+
                                " Price: " + split[1] + " ID:" + split[2]);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

