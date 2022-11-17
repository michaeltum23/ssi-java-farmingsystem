package farmingsystem.controller;

import farmingsystem.model.Respond;
import java.util.List;

/**
 *
 * @author jtamayo
 */
public interface RespondController {
    public void postResponse(Respond res);
    public List<Respond>list();
    public Respond get(int RespondId);
}
