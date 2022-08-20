package com.mber._052_conversation_scope;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ConversationScoped
public class ConversationBean implements Serializable {
    String stF;
    @Getter
    @Setter
    private String stS;

    @Inject
    private Conversation conversation;

    public void startConversation() {
        System.out.println("inside , ______________________startConversation() begin");
        printInsideStates();
        conversation.begin();
        System.out.println("inside , conversation.begin()");
        stF = "B";
        stS = "B";
        System.out.println("inside , set states - B");
        System.out.println("inside , ______________________startConversation() end");
    }

    public void printInsideStates() {
        System.out.printf("inside , stF: %s%n", stF);
        System.out.printf("inside , stS: %s%n", stS);
    }

    public void endConversation() {
        System.out.println("inside , ______________________endConversation() begin");
        printInsideStates();
        conversation.end();
        System.out.println("inside , conversation.end()");
        System.out.println("inside , ______________________endConversation() end");
    }
}
