import com.database.CSVReader;
import com.database.CustomerInvoicePOJO;
import com.database.MySQLTool;

import java.util.ArrayList;

public class Solution {
        public static void main(String[] args) {
        CSVReader file = new CSVReader("src/DataUploading.csv");		// starting CSV Reader
        ArrayList<CustomerInvoicePOJO> POJOS = file.get_ArrayList_of_POJO();	// getting POJO list from CSVReader object

		// Initialising MySQL Class with url, username and password
		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");

		ArrayList<String> queries = new ArrayList<>();		// A ArrayList to store queries
		for (CustomerInvoicePOJO x:POJOS) {
			// appending query into queries
			queries.add("insert into customer_invoice ("+x.comma_separated_keys()+") values ("+x.comma_separated_values()+")");
		}
		DB.insert_multiple_queries(queries); // Adding it to database
    }
}

