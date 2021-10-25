package com.zemoga.twitterapp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity(name="portfolio")
@Table(name="portfolio")
@Getter
@Setter
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idportfolio")
    private long idPortfolio;

    @Column
    private String description;

    @Column
    private String image_url;

    @Column
    private String twitter_user_name;

    @Column
    private String title;

    @Column(name="user_id")
    private String userId;

    @Column(name="experience_summary")
    private String experiencieSummary;

    @Column(name="last_names")
    private String lastnames;

    @Column
    private String names;

    @Column(name="twitter_user_id")
    private String twitter_user_id;
}
