package com.example.teayudaapp.messagescreen

data class MessageState(
    val isLoading: Boolean = false,
    val images: List<String> = listOf(
        "https://c2e9a7e8.rocketcdn.me/wp-content/uploads/2023/01/openAI-chat-gpt-1.jpg",
        "https://previews.123rf.com/images/pandavector/pandavector1709/pandavector170906220/86095874-icono-de-hombre-%C3%BAnico-en-estilo-de-dibujos-animados-man-s%C3%ADmbolo-de-vector-stock-de-ilustraci%C3%B3n.jpg",
        "https://c8.alamy.com/compes/jhnkyc/expresion-facial-de-un-hombre-sorprendidos-emociones-masculinas-guapo-personaje-de-dibujos-animados-ilustracion-vectorial-aislado-sobre-fondo-blanco-jhnkyc.jpg",
        "https://previews.123rf.com/images/yupiramos/yupiramos1609/yupiramos160912832/62358693-avatar-hombre-de-dibujos-animados-usuario-de-persona-masculina-ilustraci%C3%B3n-vectorial.jpg",
        "https://st2.depositphotos.com/40001914/47757/i/450/depositphotos_477579894-stock-photo-3d-rendering-businesswoman-cartoon-avatar.jpg",
        "https://thumbs.dreamstime.com/z/mujer-avatar-con-la-cara-sonriente-personaje-de-dibujos-animados-femenino-empresaria-icono-hermoso-gente-en-fondo-verde-120328294.jpg",
        "https://st2.depositphotos.com/4967775/12319/i/600/depositphotos_123190270-stock-photo-child-is-sleeping-sweet-dream.jpg",
        "https://thumbs.dreamstime.com/b/millonario-rich-man-holding-money-bag-y-vidrio-de-martini-situaci%C3%B3n-divertida-de-la-forma-de-vida-del-personaje-de-dibujos-89436486.jpg",
        "https://previews.123rf.com/images/grgroup/grgroup1611/grgroup161108933/65491779-icono-de-dibujos-animados-chica-ni%C3%B1ez-ni%C3%B1o-peque%C3%B1o-persona-personas-y-el-tema-dise%C3%B1o-aislado.jpg",
        "https://pbs.twimg.com/profile_images/1359630369608396803/VMs5IuaO_400x400.jpg",
    ),
    val names: List<String> = listOf(
        "Chat GPT",
        "Worker Guy",
        "Crazy Friend",
        "Who is?",
        "Best friend",
        "The Boss",
        "Always sleeping",
        "Workout fan",
        "My sister?",
        "Who is he?"
    )
)
