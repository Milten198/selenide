package executors;

import Objects.Person;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.getElements;

public class UploadFilePage {

    public void uploadFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Task5\\" + fileName);
        $(By.xpath("//input")).uploadFile(file);
    }

    public boolean compareTwoLists() throws Exception {
        $(By.xpath("//tbody")).shouldBe(Condition.visible);
        List<Person> table = createListOfPeopleFromTable();
        List<Person> file = createListOfPeopleFromFile();

        boolean areListsEquals = true;
        if (table.size() > 0) {
            for (int i = 0; i < table.size(); i++)
                if (!file.get(i).getName().equals(table.get(i).getName())
                        || !file.get(i).getSurname().equals(table.get(i).getSurname())
                        || !file.get(i).getPhoneNumber().equals(table.get(i).getPhoneNumber())) {
                    areListsEquals = false;
                }
        } else {
            areListsEquals = false;
        }
        return areListsEquals;
    }

    private List<Person> createListOfPeopleFromFile() {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Task5\\" + "correct.txt");
        List<Person> peopleInFile = new ArrayList<Person>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] lineData = scanner.nextLine().replaceAll("\\s", "").split(",");
                peopleInFile.add(new Person(lineData[0], lineData[1], lineData[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return peopleInFile;
    }

    private List<Person> createListOfPeopleFromTable() {
        List<Person> peopleInTable = new ArrayList<Person>();
        ElementsCollection rows = getElements(By.xpath("//tbody/tr"));
        for (int i = 1; i <= rows.size(); i++) {
            ElementsCollection record = getElements(By.xpath(String.format("//tr[%s]/td", i)));
            peopleInTable.add(new Person(record.get(0).getText(), record.get(1).getText(), record.get(2).getText()));
        }
        return peopleInTable;
    }
}
