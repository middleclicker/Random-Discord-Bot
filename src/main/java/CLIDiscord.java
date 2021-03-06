import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CLIDiscord {
    public static boolean userInput = false;
    public static boolean displayMessages = false;
    public static boolean channelWatch = false;
    public static List<ServerChannel> serverChannelsList;
    public static List<Path> serverChannelPaths = new ArrayList<>();
    public static User bot;
    public static Server server;
    public static TextChannel channel;
    public static String currentText;
    public static String botName;

    public static void main(String[] args) {
        String token = "";

        DiscordApi api = new DiscordApiBuilder().setAllIntents().setToken(token).login().join();

        botName = api.getYourself().getName();
        bot = api.getYourself();

        api.addListener(new Listeners.MessageListener());
        api.addListener(new Listeners.MemberJoinListener());
    }
}
