package executors;

import Objects.Person;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import locators.UploadFileLocators;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElements;

public class UploadFilePage {

    private UploadFileLocators locators;

    public UploadFilePage() {
        locators = new UploadFileLocators();
    }

    public void uploadFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Task5\\" + fileName);
        locators.uploadButton.uploadFile(file);
    }

    public boolean compareTwoLists() throws Exception {
        locators.tableBody.shouldBe(Condition.visible);
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
        List<SelenideElement> rows = locators.rowsNumber;
        for (int i = 1; i <= rows.size(); i++) {
            List<SelenideElement> record = locators.getRecordsFromRow(i);
            peopleInTable.add(new Person(record.get(0).getText(), record.get(1).getText(), record.get(2).getText()));
        }
        return peopleInTable;
    }
}
