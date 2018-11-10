package com.gameboys;

import lombok.extern.log4j.Log4j2;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

@Log4j2
public class GameBoys extends ListenerAdapter {

    public static final String BOTNAME = "";
    public static final String OAUTH = "";
    public static final String CHANNEL = "Rythem_n_Beezy";

    public static PircBotX bot;


    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        //When someone says ?helloworld respond with "Hello World"
        if (event.getMessage().startsWith("?hello")) {
            event.respond("Hello World!");
        }
        log.info("Message");
        log.info(event.getMessage());
    }

    public static void main(String[] args) throws Exception {
        log.info("Works");
        //Configure what we want our bot to do
        Configuration configuration = new Configuration.Builder()
                .setName(BOTNAME)
                .setServerPassword(OAUTH)//Set the nick of t he bot. CHANGE IN YOUR CODE
                .setServer("irc.chat.twitch.tv", 6667)
                .addAutoJoinChannel("#" + CHANNEL) //Join the official #pircbotx channel
                .addListener(new Bot()) //Add our listener that will be called on Events
                .buildConfiguration();

        //Create our bot with the configuration
        bot = new PircBotX(configuration);
        //Connect to the server
        bot.startBot();
    }
}
