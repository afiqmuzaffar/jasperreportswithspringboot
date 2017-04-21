/**
 *
 */
package gauravbrills.demo.jasper.web;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author grawat
 */
@Controller
public class JasperEndPoint {
  private static final Logger LOG = LoggerFactory.getLogger(JasperEndPoint.class);

    private static final String FILE_FORMAT = "format";
    private static final String DATASOURCE = "datasource";

    @Autowired
    private DataSource dbsoruce;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView getRptByParam(final ModelMap modelMap, ModelAndView modelAndView,
      @RequestParam("name") final String reportname,
      @RequestParam("format")     final String format,
      @RequestParam(value = "id" , required = false)  final Integer id) {
        LOG.debug("getRptByParam");

        modelMap.put(DATASOURCE, dbsoruce);
        modelMap.put("format", format);
        modelMap.put("id", id);

        modelAndView = new ModelAndView(reportname, modelMap);
        return modelAndView;
    }
}
