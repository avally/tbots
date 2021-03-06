package org.avally.tbots.method.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import org.avally.tbots.entity.Message;
import org.avally.tbots.entity.TelegramResponse;
import org.avally.tbots.entity.reply.ReplyMarkup;
import org.avally.tbots.method.BotMethod;

import java.io.IOException;

/**
 * Use this method to send information about a venue. On success, the sent {@link Message} is returned.
 *
 * @author Dmitry Polishchuk
 */
public class SendVenue extends BotMethod<Message> {
    //    @formatter:off
    @JsonProperty("chat_id") private String chatId;
    @JsonProperty("latitude") private Float latitude;
    @JsonProperty("longitude") private Float longitude;
    @JsonProperty("title") private String title;
    @JsonProperty("address") private String address;
    @JsonProperty("foursquare_id") private String foursquareId;
    @JsonProperty("foursquare_type") private String foursquareType;
    @JsonProperty("disable_notification") private Boolean disableNotification;
    @JsonProperty("reply_to_message_id") private Integer replyToMessageId;
    @JsonProperty("reply_markup") private ReplyMarkup replyMarkup;
    //    @formatter:on

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername).
     */
    public SendVenue setChatId(String chatId) {
        this.chatId = chatId;
        return this;
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername).
     */
    public SendVenue setChatId(Long chatId) {
        this.chatId = Long.toString(chatId);
        return this;
    }

    /**
     * Latitude of the venue.
     */
    public SendVenue setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Longitude of the venue.
     */
    public SendVenue setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Name of the venue.
     */
    public SendVenue setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Address of the venue.
     */
    public SendVenue setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Optional. Foursquare identifier of the venue.
     */
    public SendVenue setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }

    /**
     * Optional	Foursquare type of the venue, if known.
     * (For example, ???arts_entertainment/default???, ???arts_entertainment/aquarium??? or ???food/icecream???.)
     */
    public SendVenue setFoursquareType(String foursquareType) {
        this.foursquareType = foursquareType;
        return this;
    }

    /**
     * Optional. Sends the message silently. Users will receive a notification with no sound.
     */
    public SendVenue disableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    /**
     * Optional. If the message is a reply, ID of the original message.
     */
    public SendVenue setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
        return this;
    }

    /**
     * Optional. Additional interface options. A JSON-serialized object for an inline keyboard,
     * custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     */
    public SendVenue setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return this;
    }

    @Override
    public String getPath() {
        return "sendVenue";
    }

    @Override
    public TelegramResponse<Message> deserializeResponse(String input) {
        try {
            return OBJECT_MAPPER.readValue(input,
                    new TypeReference<TelegramResponse<Message>>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException("Unable to deserialize response from '" + this.getPath() + "' method call");
        }
    }
}
