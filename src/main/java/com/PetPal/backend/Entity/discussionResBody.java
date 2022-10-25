package com.PetPal.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class discussionResBody {

    private discussion discussion;
    private List<discussionReply> discussionReplies;

    public discussionResBody() {
    }
}
