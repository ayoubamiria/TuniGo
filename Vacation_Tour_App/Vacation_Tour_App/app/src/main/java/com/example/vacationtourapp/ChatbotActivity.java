package com.example.vacationtourapp;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ChatbotActivity extends AppCompatActivity {

    private LinearLayout chatLayout;
    private EditText inputMessage;
    private ScrollView chatScrollView;
    private final Map<String, String> responses = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        chatLayout = findViewById(R.id.chat_layout);
        inputMessage = findViewById(R.id.input_message);
        chatScrollView = findViewById(R.id.chat_scroll_view);
        ImageButton sendButton = findViewById(R.id.send_button);

        // Initialize predefined responses
        initializeResponses();

        sendButton.setOnClickListener(v -> {
            String message = inputMessage.getText().toString().trim();
            if (!TextUtils.isEmpty(message)) {
                addSenderMessage(message);
                inputMessage.setText("");

                // Simulate chatbot response with a delay for realism
                new Handler().postDelayed(() -> {
                    String chatbotResponse = getChatbotResponse(message);
                    addChatbotMessage(chatbotResponse);
                }, 1000);
            }
        });
    }

    private void initializeResponses() {
        responses.put("hi", "Hi there! How can I assist you with your travel plans today?");
        responses.put("hello", "Hello! I'm TouRi, your travel assistant. Ready to explore the world?");
        responses.put("who are you", "I'm TouRi, your travel chatbot. I can help you plan vacations, find destinations, and provide travel tips!");
        responses.put("what's your name", "My name is TouRi. I'm here to make your travel planning easy and fun!");
        responses.put("how are you", "I'm just a chatbot, but I'm doing great! How can I assist you today?");
        responses.put("help", "I'm here to help! Ask me about vacation spots, bookings, or travel tips.");
        responses.put("vacation", "Tell me your dream vacation destination, and I'll assist you!");
        responses.put("best places to visit", "That depends on your interests! For beaches, try the Maldives. For history, visit Rome. For adventure, explore New Zealand.");
        responses.put("recommend a beach destination", "I recommend the Maldives, Bora Bora, or Hawaii for an unforgettable beach vacation!");
        responses.put("recommend a city to visit", "Paris is a must-see for romance and culture. For technology and fun, visit Tokyo.");
        responses.put("cheap travel destinations", "Consider Southeast Asia! Thailand, Vietnam, and Cambodia offer affordable yet amazing experiences.");
        responses.put("travel tips", "Always keep your documents safe, carry a power bank, and download offline maps for convenience.");
        responses.put("can you book flights", "I can't book flights directly, but I can suggest websites like Skyscanner or Google Flights.");
        responses.put("can you book hotels", "I recommend checking Booking.com, Airbnb, or Expedia for great hotel deals.");
        responses.put("what is the best time to travel", "It depends on the destination. Research seasonal weather and peak tourist times.");
        responses.put("what is jet lag", "Jet lag is a temporary sleep disorder caused by traveling across time zones. Stay hydrated and adjust to the local time!");
        responses.put("what's your favorite destination", "I don't travel, but I've heard amazing things about Bali, Santorini, and Kyoto!");
        responses.put("recommend a winter destination", "For snow and skiing, visit Switzerland or Aspen. For a cozy winter, try Iceland.");
        responses.put("recommend a summer destination", "Explore the Greek Islands, Hawaii, or the French Riviera for the perfect summer vacation.");
        responses.put("what is a visa", "A visa is an official document permitting entry into a specific country. Check visa requirements before traveling.");
        responses.put("do I need a passport", "Yes, a valid passport is required for international travel.");
        responses.put("is travel insurance necessary", "Travel insurance is highly recommended to cover unforeseen events like medical emergencies or trip cancellations.");
        responses.put("currency exchange tips", "Compare rates before exchanging money. Avoid airport exchanges for better deals.");
        responses.put("what's a travel itinerary", "A travel itinerary is a detailed plan of your trip, including flights, hotels, and activities.");
        responses.put("how to pack light", "Pack versatile clothing, use packing cubes, and stick to essentials. Roll clothes to save space.");
        responses.put("top adventure destinations", "Try New Zealand, Patagonia, or Costa Rica for thrilling adventure activities.");
        responses.put("recommend a romantic destination", "Santorini, Maldives, and Paris are perfect for romantic getaways.");
        responses.put("is solo travel safe", "Yes, but always research your destination, stay alert, and share your plans with someone you trust.");
        responses.put("budget travel tips", "Travel off-season, use public transport, and eat at local restaurants for a budget-friendly trip.");
        responses.put("can you speak other languages", "I can respond in English, but I can try to translate simple phrases for you!");
        responses.put("is it safe to travel during COVID-19", "Always check travel restrictions and follow health guidelines for a safe journey.");
        responses.put("how to avoid jet lag", "Stay hydrated, avoid caffeine, and adjust to the local time as quickly as possible.");
        responses.put("top food destinations", "For foodies, try Italy for pasta and pizza, Japan for sushi, or Thailand for street food.");
        responses.put("top cultural destinations", "Visit Kyoto, Japan, for tradition, Cairo, Egypt, for ancient wonders, or India for vibrant culture.");
        responses.put("what's the best airline", "It depends on your needs. Emirates, Singapore Airlines, and Qatar Airways are known for great service.");
        responses.put("how to stay safe while traveling", "Be aware of your surroundings, avoid risky areas, and keep emergency contacts handy.");
        responses.put("how to book a cheap flight", "Use tools like Skyscanner or Google Flights, and book in advance for the best deals.");
        responses.put("what is a layover", "A layover is a stop at an intermediate airport between your departure and destination flights.");
        responses.put("what's the best way to travel with kids", "Plan kid-friendly activities, pack snacks and games, and take breaks during long trips.");
        responses.put("how to avoid travel scams", "Research your destination, avoid deals that seem too good to be true, and use trusted vendors.");
    }

    private String getChatbotResponse(String userMessage) {
        String normalizedMessage = userMessage.toLowerCase().trim();
        return responses.getOrDefault(normalizedMessage, "I'm not sure how to respond to that. Can you ask something else about travel?");
    }

    private void addSenderMessage(String message) {
        TextView senderMessage = createMessageBubble(message, R.drawable.sender_bubble, Gravity.END);
        chatLayout.addView(senderMessage);
        scrollToBottom();
    }

    private void addChatbotMessage(String message) {
        TextView chatbotMessage = createMessageBubble(message, R.drawable.chatbot_bubble, Gravity.START);
        chatLayout.addView(chatbotMessage);
        scrollToBottom();
    }

    private TextView createMessageBubble(String text, int backgroundResId, int gravity) {
        TextView messageBubble = new TextView(this);
        messageBubble.setText(text);
        messageBubble.setTextSize(16);
        messageBubble.setTextColor(getResources().getColor(android.R.color.white));
        messageBubble.setBackgroundResource(backgroundResId);
        messageBubble.setPadding(24, 16, 24, 16);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = gravity;
        layoutParams.setMargins(16, 8, 16, 8); // Space around each bubble
        messageBubble.setLayoutParams(layoutParams);

        return messageBubble;
    }

    private void scrollToBottom() {
        chatScrollView.post(() -> chatScrollView.fullScroll(ScrollView.FOCUS_DOWN));
    }
}
