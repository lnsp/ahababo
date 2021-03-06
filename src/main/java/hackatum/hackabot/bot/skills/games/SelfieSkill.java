package hackatum.hackabot.bot.skills.games;

import hackatum.hackabot.bot.Bot;
import hackatum.hackabot.bot.Localization;
import hackatum.hackabot.bot.User;
import hackatum.hackabot.bot.skills.StatefulSkill;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class SelfieSkill extends StatefulSkill {
    private final static Localization local = Localization.getInstance();
    @Override
    public void init(Bot context, User user) {
        super.init(context, user, 2);
    }

    @Override
    public SendMessage transition(Message message, int state) {
        switch (state) {
            case 0:
                increaseState();
                return new SendMessage()
                        .setChatId(message.getChatId())
                        .setText(local.get("Selfie", "TakePhoto"));
            case 1:
                if (message.getPhoto() == null || message.getPhoto().size() < 1) {
                    return new SendMessage()
                            .setChatId(message.getChatId())
                            .setText(local.get("Selfie", "NoPhoto"));
                }
                increaseState();
                getContext().setUserPhoto(getUser(), message.getPhoto().get(message.getPhoto().size()-1).getFileId());
        }
        return new SendMessage()
                .setChatId(message.getChatId())
                .setText(local.get("Selfie", "Received"));
    }
}
