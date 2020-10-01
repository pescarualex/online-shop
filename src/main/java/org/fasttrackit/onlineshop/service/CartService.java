package org.fasttrackit.onlineshop.service;

import org.fasttrackit.onlineshop.domain.Cart;
import org.fasttrackit.onlineshop.domain.User;
import org.fasttrackit.onlineshop.exception.ResourceNotFoundException;
import org.fasttrackit.onlineshop.persistence.CartRepository;
import org.fasttrackit.onlineshop.transfer.AddProductToCartRequest;
import org.fasttrackit.onlineshop.transfer.cart.CartResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final UserService userService;

    @Autowired
    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Transactional
    public Cart addProductToCart(AddProductToCartRequest request) {
        LOGGER.info("Adding product to cart : {}", request);

        Cart cart = cartRepository.findById(request.getUserId())
                .orElse(new Cart());

        if (cart.getUser() == null) {
            User user = userService.getUser(request.getUserId());

            cart.setUser(user);
        }

        // add product to card

        return cartRepository.save(cart);
    }

    @Transactional
    public CartResponse getCart(long userId) {
        LOGGER.info("Retrieving cart for user {}", userId);

        Optional<Cart> optional = cartRepository.findById(userId);

        Cart cart = cartRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart " + userId + " does not exist"));

        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());

        return cartResponse;
    }


}
