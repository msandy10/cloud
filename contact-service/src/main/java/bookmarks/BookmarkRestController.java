package bookmarks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping( method = RequestMethod.GET)
    Collection<Contact> getConatcs() {
        return this.contactRepository.findAll();
    }
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    Collection<Contact> getBookmarks(@PathVariable String userId) {
        return this.contactRepository.findByUserId(userId);
    }


    @RequestMapping(method = RequestMethod.POST)
    Contact createBookmark(@PathVariable String userId,
                            @RequestBody Contact bookmark) {
        Contact bookmarkInstance = new Contact(
                userId,
                bookmark.getEmailId(),
                bookmark.getFirstName(),
                bookmark.getLastName()
                );

        return this.contactRepository.save(bookmarkInstance);
    }

}