package com.zemoga.twitterapp.rest;

import com.google.gson.Gson;
import com.zemoga.twitterapp.bean.PortfolioBean;
import com.zemoga.twitterapp.model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zemoga.twitterapp.service.*;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PortfolioRest {

    private Logger logger = LoggerFactory.getLogger(PortfolioRest.class);

    @Value("${oauth.apiKey}")
    String apiKey;

    @Value("${oauth.apiSecret}")
    String apiSecret;

    @Value("${oauth.accessToken}")
    String accessToken;

    @Value("${oauth.accessTokenSecret}")
    String accessTokenSecret;

    @Autowired
    ServicePortfolio servicePortfolio;

    @GetMapping("/users")
    public List<Portfolio> getAllPortfolio(){
        return this.servicePortfolio.getAllPortfolio();
    }

    @GetMapping("/tweets")
    public String getTweets(@RequestParam("id") String twitterUsername) throws TwitterException {
        int npage = 1;
        System.out.println("username = " + twitterUsername);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(this.apiKey)
                .setOAuthConsumerSecret(this.apiSecret)
                .setOAuthAccessToken(this.accessToken)
                .setOAuthAccessTokenSecret(this.accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Paging page = new Paging(npage++, 100);
        ResponseList<Status> result = twitter.getUserTimeline(twitterUsername, page);
        String json = new Gson().toJson(result);
        return json;
    }

    @RequestMapping(value = "/editPxrofile",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editProfile(@RequestBody PortfolioBean portfolio){
        System.out.println(portfolio.getNames());
        return "123";
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Object> updateTutorial(@PathVariable("id") long id, @RequestBody PortfolioBean portfolio) {
    try{

            Portfolio p = servicePortfolio.findPortfolioBydId(id);
            p.setDescription(portfolio.getDescription());
            p.setExperiencieSummary(portfolio.getWorksummary());
            p.setNames(portfolio.getNames());
            p.setLastnames(portfolio.getLastnames());

            Portfolio savedProfile = servicePortfolio.savePortfolio(p);
            return new ResponseEntity<Object>(savedProfile, HttpStatus.OK);

        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
}
