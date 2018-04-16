package useCase;

import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;

import model.BacklogItem;
import model.CommittedBacklogItem;
import model.Product;
import model.Sprint;
import model.Task;

public class ApplicationContext {

	private Map<String, Product> products;
	private Map<String, BacklogItem> backlogItems;
	private Map<String, CommittedBacklogItem> committedBacklogItems;
	private Map<String, Sprint> sprints;
	private Map<String, Task> tasks;
	
	public ApplicationContext() {
		products = Collections.synchronizedMap(new LinkedHashMap<String, Product>());
		backlogItems = Collections.synchronizedMap(new LinkedHashMap<String, BacklogItem>());
		committedBacklogItems = Collections.synchronizedMap(new LinkedHashMap<String, CommittedBacklogItem>());
		sprints = Collections.synchronizedMap(new LinkedHashMap<String, Sprint>());
		tasks = Collections.synchronizedMap(new LinkedHashMap<String, Task>());
	}
	public static ApplicationContext newInstance() {
		return new ApplicationContext();
	}
	public Map<String, Product> getProducts() {
		return products;
	}
	public Map<String, BacklogItem> getBacklogItems() {
		return backlogItems;
	}
	public Map<String, CommittedBacklogItem> getCommittedBacklogItems(){
		return committedBacklogItems;
	}
	public Map<String, Sprint> getSprints() {
		return sprints;
	}
	
	public Map<String, Task> getTasks(){
		return tasks;
	}
}
