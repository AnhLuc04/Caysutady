package ShopRepository;

import Shop.Shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Repository {
    public ArrayList<Shop> repoList;

    public Repository() throws IOException {
        this.repoList = new ArrayList<>();
        BufferedReader bufReader = new BufferedReader(new FileReader("C:\\Users\\Admin\\IdeaProjects\\Text2\\CaseStudy\\src\\Shop.txt"));
        String line = bufReader.readLine();
        while (line != null) {
            Shop a = new Shop();
            String[] data = line.split(",");
            a.setID(parseInt(data[0]));
            a.setName(data[1]);
            String priceString = data[2];
            String[] priceS = priceString.split("\\.");
            a.setPrice(parseInt(priceS[0].trim()));
            repoList.add(a);
            line = bufReader.readLine();
        }
        bufReader.close();
    }
}
