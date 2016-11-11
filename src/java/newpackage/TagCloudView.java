package newpackage;
 
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;
 
@ManagedBean (name="tagCloudView")

public class TagCloudView {
     
    private TagCloudModel model;
     
    @PostConstruct
    public void init() {
        model = new DefaultTagCloudModel();
        model.addTag(new DefaultTagCloudItem("Einführung ins Programmieren", 5));
        model.addTag(new DefaultTagCloudItem("IT Tools und Entwicklungs- umgebungen", 3));
        model.addTag(new DefaultTagCloudItem("IT Infrastruktur", 4));
        model.addTag(new DefaultTagCloudItem("Datenbank Basics", 3));
        model.addTag(new DefaultTagCloudItem("Projektmanagement", 2));
        model.addTag(new DefaultTagCloudItem("Teamwork", 2));
        model.addTag(new DefaultTagCloudItem("Personal and Social Communication", 2));
        model.addTag(new DefaultTagCloudItem("Kickoff", 1));

    }
 
    public TagCloudModel getModel() {
        return model;
    }
     
    public void onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
