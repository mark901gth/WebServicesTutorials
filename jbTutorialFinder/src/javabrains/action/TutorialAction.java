package javabrains.action;

import javabrains.service.TutorialFinderService;

public class TutorialAction
{

    private String bestTutorialSite;
    private String language;


    public String getLanguage()
    {
        return language;
    }


    public void setLanguage(String language)
    {
        this.language = language;
    }


    public String getBestTutorialSite()
    {
        return bestTutorialSite;
    }


    public void setBestTutorialSite(String bestTutorialSite)
    {
        this.bestTutorialSite = bestTutorialSite;
    }


    public String getTutorial()
    {
//        TutorialFinderService tutorialFinderService = new TutorialFinderService();
//        System.out.println( getLanguage() );
//        setBestTutorialSite( tutorialFinderService.getBestTutorialSite( getLanguage() ) );
        System.out.println( "getTutorial() method executed." );

        return "success-code";
    }


    public String addTutorial()
    {
//        TutorialFinderService tutorialFinderService = new TutorialFinderService();
//        System.out.println( getLanguage() );
//        setBestTutorialSite( tutorialFinderService.getBestTutorialSite( getLanguage() ) );
        System.out.println( "addTutorial() method executed." );

        return "success-code";
    }

}
