package ir.tehran.jug.projects.eventmanagement.web.telegram.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class EventManagerBot extends TelegramLongPollingBot {

    public EventManagerBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("\"به برنامه مدیریت ایونت JUG خوش آمدید \uD83D\uDC4B\uD83D\uDE0D\"");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());

                    // KeyboardButton
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    replyKeyboardMarkup.setSelective(true);

                    List<KeyboardRow> keyboardRowList = new ArrayList<>();
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardRow keyboardRow2 = new KeyboardRow();

                    KeyboardButton keyboardButton1 = new KeyboardButton();
                    keyboardButton1.setText("منوی برگزار کننده");

                    KeyboardButton keyboardButton2 = new KeyboardButton();
                    keyboardButton2.setText("منوی شرکت کننده");

                    keyboardRow1.add(keyboardButton1);
                    keyboardRow2.add(keyboardButton2);

                    keyboardRowList.add(keyboardRow1);
                    keyboardRowList.add(keyboardRow2);

                    replyKeyboardMarkup.setKeyboard(keyboardRowList);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);


                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (message.getText().equals("منوی برگزار کننده")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("خدمات مربوط به برگزاری ایونت");
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setParseMode(ParseMode.MARKDOWN);

                    // InlineKeyboardButton
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

                    List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();

                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();

                    inlineKeyboardButton1.setText("ايجاد يك رویداد جدید");

                    inlineKeyboardButton1.setCallbackData("ايجاد يك رویداد جدید");

                    inlineKeyboardButtonList1.add(inlineKeyboardButton1);

                    inlineButtons.add(inlineKeyboardButtonList1);
                    inlineButtons.add(inlineKeyboardButtonList2);

                    inlineKeyboardMarkup.setKeyboard(inlineButtons);
                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

            }
        } else if (update.hasCallbackQuery()) {
            Message message = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setParseMode(ParseMode.MARKDOWN);
            sendMessage.setChatId(message.getChatId());

            if (data.equals("ايجاد يك رویداد جدید")) {
                sendMessage.setText("رويداد جديد ساخته شد");
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Jug2024Bot";
    }
}

