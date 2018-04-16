package factory.domainModel;

import java.util.UUID;

import model.BacklogItem;
import model.CommittedBacklogItem;
import model.ezScrumDomainModel;

public class CommittedBacklogItemFactory implements DomainModelFactory{
	
	private String sprintId;
	private BacklogItem backlogItem;

	public CommittedBacklogItemFactory() {}
	
	public CommittedBacklogItemFactory(String sprintId, BacklogItem backlogItem) {
		this.sprintId = sprintId;
		this.backlogItem = backlogItem;
	}
	
	public ezScrumDomainModel createDomainModel() {
		String committedBacklogItemId = UUID.randomUUID().toString();
		CommittedBacklogItem committedBacklogItem = new CommittedBacklogItem(sprintId, backlogItem);
		committedBacklogItem.setCommittedBacklogItemId(committedBacklogItemId);
		return committedBacklogItem;
	}
}
