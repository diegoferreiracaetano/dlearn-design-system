#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class DesignSystemAppBottomNavigation, DesignSystemAppChip, DesignSystemAppNavigationTab, DesignSystemAppSelectionOption, DesignSystemButtonType, DesignSystemCarouselItem, DesignSystemColorFamily, DesignSystemDrawerItem, DesignSystemExtendedColorScheme, DesignSystemFoundationCornerBasedShape, DesignSystemKotlinArray<T>, DesignSystemKotlinEnum<E>, DesignSystemKotlinEnumCompanion, DesignSystemKotlinException, DesignSystemKotlinIllegalStateException, DesignSystemKotlinRuntimeException, DesignSystemKotlinThrowable, DesignSystemLibraryDrawableResource, DesignSystemLibraryResource, DesignSystemLibraryResourceItem, DesignSystemMaterial3Shapes, DesignSystemMaterial3SnackbarDuration, DesignSystemMaterial3SnackbarHostState, DesignSystemMaterial3SnackbarResult, DesignSystemPlatformType, DesignSystemRuntimeCompositionLocal<T>, DesignSystemRuntimeProvidableCompositionLocal<T>, DesignSystemRuntimeProvidedValue<T>, DesignSystemSnackbarType, DesignSystemTextFieldType, DesignSystemUiImageVector, DesignSystemUiImageVectorCompanion, DesignSystemUiVectorGroup, DesignSystemUiVectorNode, DesignSystemUi_geometryRect, DesignSystemUi_geometryRectCompanion, DesignSystemUi_graphicsOutline, DesignSystemUi_graphicsPathNode, DesignSystemUi_unitDpRect, DesignSystemUi_unitDpRectCompanion, DesignSystemUi_unitLayoutDirection;

@protocol DesignSystemFoundationCornerSize, DesignSystemKotlinComparable, DesignSystemKotlinCoroutineContext, DesignSystemKotlinCoroutineContextElement, DesignSystemKotlinCoroutineContextKey, DesignSystemKotlinIterable, DesignSystemKotlinIterator, DesignSystemKotlinx_coroutines_coreCoroutineScope, DesignSystemLibraryQualifier, DesignSystemMaterial3SnackbarData, DesignSystemMaterial3SnackbarVisuals, DesignSystemRuntimeCompositionLocalAccessorScope, DesignSystemUi_graphicsShape, DesignSystemUi_unitDensity, DesignSystemUi_unitFontScalingLinear;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface DesignSystemBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface DesignSystemBase (DesignSystemBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface DesignSystemMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface DesignSystemMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorDesignSystemKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface DesignSystemNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface DesignSystemByte : DesignSystemNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface DesignSystemUByte : DesignSystemNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface DesignSystemShort : DesignSystemNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface DesignSystemUShort : DesignSystemNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface DesignSystemInt : DesignSystemNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface DesignSystemUInt : DesignSystemNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface DesignSystemLong : DesignSystemNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface DesignSystemULong : DesignSystemNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface DesignSystemFloat : DesignSystemNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface DesignSystemDouble : DesignSystemNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface DesignSystemBoolean : DesignSystemNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((swift_name("KotlinComparable")))
@protocol DesignSystemKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface DesignSystemKotlinEnum<E> : DesignSystemBase <DesignSystemKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) DesignSystemKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SnackbarType")))
@interface DesignSystemSnackbarType : DesignSystemKotlinEnum<DesignSystemSnackbarType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemSnackbarType *error __attribute__((swift_name("error")));
@property (class, readonly) DesignSystemSnackbarType *success __attribute__((swift_name("success")));
@property (class, readonly) DesignSystemSnackbarType *warning __attribute__((swift_name("warning")));
+ (DesignSystemKotlinArray<DesignSystemSnackbarType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemSnackbarType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppSelectionOption")))
@interface DesignSystemAppSelectionOption : DesignSystemBase
- (instancetype)initWithLabel:(NSString *)label value:(id)value color:(uint64_t)color __attribute__((swift_name("init(label:value:color:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemAppSelectionOption *)doCopyLabel:(NSString *)label value:(id)value color:(uint64_t)color __attribute__((swift_name("doCopy(label:value:color:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) uint64_t color __attribute__((swift_name("color")));
@property (readonly) NSString *label __attribute__((swift_name("label")));
@property (readonly) id value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ButtonType")))
@interface DesignSystemButtonType : DesignSystemKotlinEnum<DesignSystemButtonType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemButtonType *primary __attribute__((swift_name("primary")));
@property (class, readonly) DesignSystemButtonType *secondary __attribute__((swift_name("secondary")));
@property (class, readonly) DesignSystemButtonType *tertiary __attribute__((swift_name("tertiary")));
+ (DesignSystemKotlinArray<DesignSystemButtonType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemButtonType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CarouselItem")))
@interface DesignSystemCarouselItem : DesignSystemBase
- (instancetype)initWithTitle:(NSString *)title subtitle:(NSString * _Nullable)subtitle rating:(float)rating imageResource:(DesignSystemLibraryDrawableResource * _Nullable)imageResource imageUrl:(NSString * _Nullable)imageUrl primaryInfo:(NSString * _Nullable)primaryInfo secondaryInfo:(NSString * _Nullable)secondaryInfo rank:(DesignSystemInt * _Nullable)rank onClick:(void (^)(void))onClick __attribute__((swift_name("init(title:subtitle:rating:imageResource:imageUrl:primaryInfo:secondaryInfo:rank:onClick:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemCarouselItem *)doCopyTitle:(NSString *)title subtitle:(NSString * _Nullable)subtitle rating:(float)rating imageResource:(DesignSystemLibraryDrawableResource * _Nullable)imageResource imageUrl:(NSString * _Nullable)imageUrl primaryInfo:(NSString * _Nullable)primaryInfo secondaryInfo:(NSString * _Nullable)secondaryInfo rank:(DesignSystemInt * _Nullable)rank onClick:(void (^)(void))onClick __attribute__((swift_name("doCopy(title:subtitle:rating:imageResource:imageUrl:primaryInfo:secondaryInfo:rank:onClick:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DesignSystemLibraryDrawableResource * _Nullable imageResource __attribute__((swift_name("imageResource")));
@property (readonly) NSString * _Nullable imageUrl __attribute__((swift_name("imageUrl")));
@property (readonly) void (^onClick)(void) __attribute__((swift_name("onClick")));
@property (readonly) NSString * _Nullable primaryInfo __attribute__((swift_name("primaryInfo")));
@property (readonly) DesignSystemInt * _Nullable rank __attribute__((swift_name("rank")));
@property (readonly) float rating __attribute__((swift_name("rating")));
@property (readonly) NSString * _Nullable secondaryInfo __attribute__((swift_name("secondaryInfo")));
@property (readonly) NSString * _Nullable subtitle __attribute__((swift_name("subtitle")));
@property (readonly) NSString *title __attribute__((swift_name("title")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppChip")))
@interface DesignSystemAppChip : DesignSystemBase
- (instancetype)initWithLabel:(NSString *)label onClick:(void (^)(void))onClick hasDropDown:(BOOL)hasDropDown isFilter:(BOOL)isFilter __attribute__((swift_name("init(label:onClick:hasDropDown:isFilter:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemAppChip *)doCopyLabel:(NSString *)label onClick:(void (^)(void))onClick hasDropDown:(BOOL)hasDropDown isFilter:(BOOL)isFilter __attribute__((swift_name("doCopy(label:onClick:hasDropDown:isFilter:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL hasDropDown __attribute__((swift_name("hasDropDown")));
@property (readonly) BOOL isFilter __attribute__((swift_name("isFilter")));
@property (readonly) NSString *label __attribute__((swift_name("label")));
@property (readonly) void (^onClick)(void) __attribute__((swift_name("onClick")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppBottomNavigation")))
@interface DesignSystemAppBottomNavigation : DesignSystemBase
- (instancetype)initWithSelectedRoute:(NSString *)selectedRoute items:(NSArray<DesignSystemAppNavigationTab *> *)items onTabSelected:(void (^)(NSString *))onTabSelected __attribute__((swift_name("init(selectedRoute:items:onTabSelected:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemAppBottomNavigation *)doCopySelectedRoute:(NSString *)selectedRoute items:(NSArray<DesignSystemAppNavigationTab *> *)items onTabSelected:(void (^)(NSString *))onTabSelected __attribute__((swift_name("doCopy(selectedRoute:items:onTabSelected:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<DesignSystemAppNavigationTab *> *items __attribute__((swift_name("items")));
@property (readonly) void (^onTabSelected)(NSString *) __attribute__((swift_name("onTabSelected")));
@property (readonly) NSString *selectedRoute __attribute__((swift_name("selectedRoute")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppNavigationTab")))
@interface DesignSystemAppNavigationTab : DesignSystemBase
- (instancetype)initWithRoute:(NSString *)route label:(NSString *)label selectedIcon:(DesignSystemUiImageVector *)selectedIcon unselectedIcon:(DesignSystemUiImageVector *)unselectedIcon __attribute__((swift_name("init(route:label:selectedIcon:unselectedIcon:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemAppNavigationTab *)doCopyRoute:(NSString *)route label:(NSString *)label selectedIcon:(DesignSystemUiImageVector *)selectedIcon unselectedIcon:(DesignSystemUiImageVector *)unselectedIcon __attribute__((swift_name("doCopy(route:label:selectedIcon:unselectedIcon:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *label __attribute__((swift_name("label")));
@property (readonly) NSString *route __attribute__((swift_name("route")));
@property (readonly) DesignSystemUiImageVector *selectedIcon __attribute__((swift_name("selectedIcon")));
@property (readonly) DesignSystemUiImageVector *unselectedIcon __attribute__((swift_name("unselectedIcon")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DrawerItem")))
@interface DesignSystemDrawerItem : DesignSystemBase
- (instancetype)initWithRoute:(NSString *)route icon:(DesignSystemUiImageVector *)icon __attribute__((swift_name("init(route:icon:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemDrawerItem *)doCopyRoute:(NSString *)route icon:(DesignSystemUiImageVector *)icon __attribute__((swift_name("doCopy(route:icon:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DesignSystemUiImageVector *icon __attribute__((swift_name("icon")));
@property (readonly) NSString *route __attribute__((swift_name("route")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("TextFieldType")))
@interface DesignSystemTextFieldType : DesignSystemKotlinEnum<DesignSystemTextFieldType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemTextFieldType *email __attribute__((swift_name("email")));
@property (class, readonly) DesignSystemTextFieldType *password __attribute__((swift_name("password")));
@property (class, readonly) DesignSystemTextFieldType *none __attribute__((swift_name("none")));
+ (DesignSystemKotlinArray<DesignSystemTextFieldType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemTextFieldType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ColorFamily")))
@interface DesignSystemColorFamily : DesignSystemBase
- (instancetype)initWithColor:(uint64_t)color onColor:(uint64_t)onColor colorContainer:(uint64_t)colorContainer onColorContainer:(uint64_t)onColorContainer __attribute__((swift_name("init(color:onColor:colorContainer:onColorContainer:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemColorFamily *)doCopyColor:(uint64_t)color onColor:(uint64_t)onColor colorContainer:(uint64_t)colorContainer onColorContainer:(uint64_t)onColorContainer __attribute__((swift_name("doCopy(color:onColor:colorContainer:onColorContainer:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) uint64_t color __attribute__((swift_name("color")));
@property (readonly) uint64_t colorContainer __attribute__((swift_name("colorContainer")));
@property (readonly) uint64_t onColor __attribute__((swift_name("onColor")));
@property (readonly) uint64_t onColorContainer __attribute__((swift_name("onColorContainer")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExtendedColorScheme")))
@interface DesignSystemExtendedColorScheme : DesignSystemBase
- (instancetype)initWithSuccess:(DesignSystemColorFamily *)success warning:(DesignSystemColorFamily *)warning __attribute__((swift_name("init(success:warning:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemExtendedColorScheme *)doCopySuccess:(DesignSystemColorFamily *)success warning:(DesignSystemColorFamily *)warning __attribute__((swift_name("doCopy(success:warning:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DesignSystemColorFamily *success __attribute__((swift_name("success")));
@property (readonly) DesignSystemColorFamily *warning __attribute__((swift_name("warning")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformType")))
@interface DesignSystemPlatformType : DesignSystemKotlinEnum<DesignSystemPlatformType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemPlatformType *android __attribute__((swift_name("android")));
@property (class, readonly) DesignSystemPlatformType *ios __attribute__((swift_name("ios")));
@property (class, readonly) DesignSystemPlatformType *other __attribute__((swift_name("other")));
+ (DesignSystemKotlinArray<DesignSystemPlatformType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemPlatformType *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Material3SnackbarHostState")))
@interface DesignSystemMaterial3SnackbarHostState : DesignSystemBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)showSnackbarVisuals:(id<DesignSystemMaterial3SnackbarVisuals>)visuals completionHandler:(void (^)(DesignSystemMaterial3SnackbarResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("showSnackbar(visuals:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)showSnackbarMessage:(NSString *)message actionLabel:(NSString * _Nullable)actionLabel withDismissAction:(BOOL)withDismissAction duration:(DesignSystemMaterial3SnackbarDuration *)duration completionHandler:(void (^)(DesignSystemMaterial3SnackbarResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("showSnackbar(message:actionLabel:withDismissAction:duration:completionHandler:)")));
@property (readonly) id<DesignSystemMaterial3SnackbarData> _Nullable currentSnackbarData __attribute__((swift_name("currentSnackbarData")));
@end

@interface DesignSystemMaterial3SnackbarHostState (Extensions)
- (void)showAppSnackBarScope:(id<DesignSystemKotlinx_coroutines_coreCoroutineScope>)scope message:(NSString *)message actionLabel:(NSString * _Nullable)actionLabel withDismissAction:(BOOL)withDismissAction duration:(DesignSystemMaterial3SnackbarDuration *)duration type:(DesignSystemSnackbarType *)type __attribute__((swift_name("showAppSnackBar(scope:message:actionLabel:withDismissAction:duration:type:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ColorsKt")))
@interface DesignSystemColorsKt : DesignSystemBase
@property (class, readonly) uint64_t backgroundDark __attribute__((swift_name("backgroundDark")));
@property (class, readonly) uint64_t backgroundLight __attribute__((swift_name("backgroundLight")));
@property (class, readonly) uint64_t errorContainerDark __attribute__((swift_name("errorContainerDark")));
@property (class, readonly) uint64_t errorContainerLight __attribute__((swift_name("errorContainerLight")));
@property (class, readonly) uint64_t errorDark __attribute__((swift_name("errorDark")));
@property (class, readonly) uint64_t errorLight __attribute__((swift_name("errorLight")));
@property (class, readonly) uint64_t inverseOnSurfaceDark __attribute__((swift_name("inverseOnSurfaceDark")));
@property (class, readonly) uint64_t inverseOnSurfaceLight __attribute__((swift_name("inverseOnSurfaceLight")));
@property (class, readonly) uint64_t inversePrimaryDark __attribute__((swift_name("inversePrimaryDark")));
@property (class, readonly) uint64_t inversePrimaryLight __attribute__((swift_name("inversePrimaryLight")));
@property (class, readonly) uint64_t inverseSurfaceDark __attribute__((swift_name("inverseSurfaceDark")));
@property (class, readonly) uint64_t inverseSurfaceLight __attribute__((swift_name("inverseSurfaceLight")));
@property (class, readonly) uint64_t onBackgroundDark __attribute__((swift_name("onBackgroundDark")));
@property (class, readonly) uint64_t onBackgroundLight __attribute__((swift_name("onBackgroundLight")));
@property (class, readonly) uint64_t onErrorContainerDark __attribute__((swift_name("onErrorContainerDark")));
@property (class, readonly) uint64_t onErrorContainerLight __attribute__((swift_name("onErrorContainerLight")));
@property (class, readonly) uint64_t onErrorDark __attribute__((swift_name("onErrorDark")));
@property (class, readonly) uint64_t onErrorLight __attribute__((swift_name("onErrorLight")));
@property (class, readonly) uint64_t onPrimaryContainerDark __attribute__((swift_name("onPrimaryContainerDark")));
@property (class, readonly) uint64_t onPrimaryContainerLight __attribute__((swift_name("onPrimaryContainerLight")));
@property (class, readonly) uint64_t onPrimaryDark __attribute__((swift_name("onPrimaryDark")));
@property (class, readonly) uint64_t onPrimaryLight __attribute__((swift_name("onPrimaryLight")));
@property (class, readonly) uint64_t onSecondaryContainerDark __attribute__((swift_name("onSecondaryContainerDark")));
@property (class, readonly) uint64_t onSecondaryContainerLight __attribute__((swift_name("onSecondaryContainerLight")));
@property (class, readonly) uint64_t onSecondaryDark __attribute__((swift_name("onSecondaryDark")));
@property (class, readonly) uint64_t onSecondaryLight __attribute__((swift_name("onSecondaryLight")));
@property (class, readonly) uint64_t onSuccessContainerDark __attribute__((swift_name("onSuccessContainerDark")));
@property (class, readonly) uint64_t onSuccessDark __attribute__((swift_name("onSuccessDark")));
@property (class, readonly) uint64_t onSurfaceDark __attribute__((swift_name("onSurfaceDark")));
@property (class, readonly) uint64_t onSurfaceLight __attribute__((swift_name("onSurfaceLight")));
@property (class, readonly) uint64_t onSurfaceVariantDark __attribute__((swift_name("onSurfaceVariantDark")));
@property (class, readonly) uint64_t onSurfaceVariantLight __attribute__((swift_name("onSurfaceVariantLight")));
@property (class, readonly) uint64_t onTertiaryContainerDark __attribute__((swift_name("onTertiaryContainerDark")));
@property (class, readonly) uint64_t onTertiaryContainerLight __attribute__((swift_name("onTertiaryContainerLight")));
@property (class, readonly) uint64_t onTertiaryDark __attribute__((swift_name("onTertiaryDark")));
@property (class, readonly) uint64_t onTertiaryLight __attribute__((swift_name("onTertiaryLight")));
@property (class, readonly) uint64_t onWarningContainerDark __attribute__((swift_name("onWarningContainerDark")));
@property (class, readonly) uint64_t onWarningDark __attribute__((swift_name("onWarningDark")));
@property (class, readonly) uint64_t outlineDark __attribute__((swift_name("outlineDark")));
@property (class, readonly) uint64_t outlineLight __attribute__((swift_name("outlineLight")));
@property (class, readonly) uint64_t outlineVariantDark __attribute__((swift_name("outlineVariantDark")));
@property (class, readonly) uint64_t outlineVariantLight __attribute__((swift_name("outlineVariantLight")));
@property (class, readonly) uint64_t primaryContainerDark __attribute__((swift_name("primaryContainerDark")));
@property (class, readonly) uint64_t primaryContainerLight __attribute__((swift_name("primaryContainerLight")));
@property (class, readonly) uint64_t primaryDark __attribute__((swift_name("primaryDark")));
@property (class, readonly) uint64_t primaryLight __attribute__((swift_name("primaryLight")));
@property (class, readonly) uint64_t scrimDark __attribute__((swift_name("scrimDark")));
@property (class, readonly) uint64_t scrimLight __attribute__((swift_name("scrimLight")));
@property (class, readonly) uint64_t secondaryContainerDark __attribute__((swift_name("secondaryContainerDark")));
@property (class, readonly) uint64_t secondaryContainerLight __attribute__((swift_name("secondaryContainerLight")));
@property (class, readonly) uint64_t secondaryDark __attribute__((swift_name("secondaryDark")));
@property (class, readonly) uint64_t secondaryLight __attribute__((swift_name("secondaryLight")));
@property (class, readonly) uint64_t successContainerDark __attribute__((swift_name("successContainerDark")));
@property (class, readonly) uint64_t successDark __attribute__((swift_name("successDark")));
@property (class, readonly) uint64_t surfaceBrightDark __attribute__((swift_name("surfaceBrightDark")));
@property (class, readonly) uint64_t surfaceBrightLight __attribute__((swift_name("surfaceBrightLight")));
@property (class, readonly) uint64_t surfaceContainerDark __attribute__((swift_name("surfaceContainerDark")));
@property (class, readonly) uint64_t surfaceContainerHighDark __attribute__((swift_name("surfaceContainerHighDark")));
@property (class, readonly) uint64_t surfaceContainerHighLight __attribute__((swift_name("surfaceContainerHighLight")));
@property (class, readonly) uint64_t surfaceContainerHighestDark __attribute__((swift_name("surfaceContainerHighestDark")));
@property (class, readonly) uint64_t surfaceContainerHighestLight __attribute__((swift_name("surfaceContainerHighestLight")));
@property (class, readonly) uint64_t surfaceContainerLight __attribute__((swift_name("surfaceContainerLight")));
@property (class, readonly) uint64_t surfaceContainerLowDark __attribute__((swift_name("surfaceContainerLowDark")));
@property (class, readonly) uint64_t surfaceContainerLowLight __attribute__((swift_name("surfaceContainerLowLight")));
@property (class, readonly) uint64_t surfaceContainerLowestDark __attribute__((swift_name("surfaceContainerLowestDark")));
@property (class, readonly) uint64_t surfaceContainerLowestLight __attribute__((swift_name("surfaceContainerLowestLight")));
@property (class, readonly) uint64_t surfaceDark __attribute__((swift_name("surfaceDark")));
@property (class, readonly) uint64_t surfaceDimDark __attribute__((swift_name("surfaceDimDark")));
@property (class, readonly) uint64_t surfaceDimLight __attribute__((swift_name("surfaceDimLight")));
@property (class, readonly) uint64_t surfaceLight __attribute__((swift_name("surfaceLight")));
@property (class, readonly) uint64_t surfaceVariantDark __attribute__((swift_name("surfaceVariantDark")));
@property (class, readonly) uint64_t surfaceVariantLight __attribute__((swift_name("surfaceVariantLight")));
@property (class, readonly) uint64_t tertiaryContainerDark __attribute__((swift_name("tertiaryContainerDark")));
@property (class, readonly) uint64_t tertiaryContainerLight __attribute__((swift_name("tertiaryContainerLight")));
@property (class, readonly) uint64_t tertiaryDark __attribute__((swift_name("tertiaryDark")));
@property (class, readonly) uint64_t tertiaryLight __attribute__((swift_name("tertiaryLight")));
@property (class, readonly) uint64_t warningContainerDark __attribute__((swift_name("warningContainerDark")));
@property (class, readonly) uint64_t warningDark __attribute__((swift_name("warningDark")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform_iosKt")))
@interface DesignSystemPlatform_iosKt : DesignSystemBase
@property (class, readonly) DesignSystemPlatformType *currentPlatform __attribute__((swift_name("currentPlatform")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PlatformKt")))
@interface DesignSystemPlatformKt : DesignSystemBase
@property (class, readonly) BOOL isIOS __attribute__((swift_name("isIOS")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ShapesKt")))
@interface DesignSystemShapesKt : DesignSystemBase
@property (class, readonly) DesignSystemMaterial3Shapes *Shapes __attribute__((swift_name("Shapes")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ThemeKt")))
@interface DesignSystemThemeKt : DesignSystemBase
@property (class, readonly) DesignSystemRuntimeProvidableCompositionLocal<DesignSystemExtendedColorScheme *> *LocalExtendedColorScheme __attribute__((swift_name("LocalExtendedColorScheme")));
@property (class, readonly) DesignSystemExtendedColorScheme *extendedColors __attribute__((swift_name("extendedColors")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UIExtensionsKt")))
@interface DesignSystemUIExtensionsKt : DesignSystemBase
+ (uint64_t)contrastTextColor:(uint64_t)receiver __attribute__((swift_name("contrastTextColor(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface DesignSystemKotlinEnumCompanion : DesignSystemBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) DesignSystemKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface DesignSystemKotlinArray<T> : DesignSystemBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(DesignSystemInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<DesignSystemKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((swift_name("LibraryResource")))
@interface DesignSystemLibraryResource : DesignSystemBase
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LibraryDrawableResource")))
@interface DesignSystemLibraryDrawableResource : DesignSystemLibraryResource
- (instancetype)initWithId:(NSString *)id items:(NSSet<DesignSystemLibraryResourceItem *> *)items __attribute__((swift_name("init(id:items:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiImageVector")))
@interface DesignSystemUiImageVector : DesignSystemBase
@property (class, readonly, getter=companion) DesignSystemUiImageVectorCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
@property (readonly) BOOL autoMirror __attribute__((swift_name("autoMirror")));
@property (readonly) float defaultHeight __attribute__((swift_name("defaultHeight")));
@property (readonly) float defaultWidth __attribute__((swift_name("defaultWidth")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) DesignSystemUiVectorGroup *root __attribute__((swift_name("root")));
@property (readonly) int32_t tintBlendMode __attribute__((swift_name("tintBlendMode")));
@property (readonly) uint64_t tintColor __attribute__((swift_name("tintColor")));
@property (readonly) float viewportHeight __attribute__((swift_name("viewportHeight")));
@property (readonly) float viewportWidth __attribute__((swift_name("viewportWidth")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface DesignSystemKotlinThrowable : DesignSystemBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (DesignSystemKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DesignSystemKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface DesignSystemKotlinException : DesignSystemKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface DesignSystemKotlinRuntimeException : DesignSystemKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface DesignSystemKotlinIllegalStateException : DesignSystemKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface DesignSystemKotlinCancellationException : DesignSystemKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DesignSystemKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("Material3SnackbarVisuals")))
@protocol DesignSystemMaterial3SnackbarVisuals
@required
@property (readonly) NSString * _Nullable actionLabel __attribute__((swift_name("actionLabel")));
@property (readonly) DesignSystemMaterial3SnackbarDuration *duration __attribute__((swift_name("duration")));
@property (readonly) NSString *message __attribute__((swift_name("message")));
@property (readonly) BOOL withDismissAction __attribute__((swift_name("withDismissAction")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Material3SnackbarResult")))
@interface DesignSystemMaterial3SnackbarResult : DesignSystemKotlinEnum<DesignSystemMaterial3SnackbarResult *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemMaterial3SnackbarResult *dismissed __attribute__((swift_name("dismissed")));
@property (class, readonly) DesignSystemMaterial3SnackbarResult *actionperformed __attribute__((swift_name("actionperformed")));
+ (DesignSystemKotlinArray<DesignSystemMaterial3SnackbarResult *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemMaterial3SnackbarResult *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Material3SnackbarDuration")))
@interface DesignSystemMaterial3SnackbarDuration : DesignSystemKotlinEnum<DesignSystemMaterial3SnackbarDuration *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemMaterial3SnackbarDuration *short_ __attribute__((swift_name("short_")));
@property (class, readonly) DesignSystemMaterial3SnackbarDuration *long_ __attribute__((swift_name("long_")));
@property (class, readonly) DesignSystemMaterial3SnackbarDuration *indefinite __attribute__((swift_name("indefinite")));
+ (DesignSystemKotlinArray<DesignSystemMaterial3SnackbarDuration *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemMaterial3SnackbarDuration *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("Material3SnackbarData")))
@protocol DesignSystemMaterial3SnackbarData
@required
- (void)dismiss __attribute__((swift_name("dismiss()")));
- (void)performAction __attribute__((swift_name("performAction()")));
@property (readonly) id<DesignSystemMaterial3SnackbarVisuals> visuals __attribute__((swift_name("visuals")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol DesignSystemKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<DesignSystemKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Material3Shapes")))
@interface DesignSystemMaterial3Shapes : DesignSystemBase
- (instancetype)initWithExtraSmall:(DesignSystemFoundationCornerBasedShape *)extraSmall small:(DesignSystemFoundationCornerBasedShape *)small medium:(DesignSystemFoundationCornerBasedShape *)medium large:(DesignSystemFoundationCornerBasedShape *)large extraLarge:(DesignSystemFoundationCornerBasedShape *)extraLarge __attribute__((swift_name("init(extraSmall:small:medium:large:extraLarge:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemMaterial3Shapes *)doCopyExtraSmall:(DesignSystemFoundationCornerBasedShape *)extraSmall small:(DesignSystemFoundationCornerBasedShape *)small medium:(DesignSystemFoundationCornerBasedShape *)medium large:(DesignSystemFoundationCornerBasedShape *)large extraLarge:(DesignSystemFoundationCornerBasedShape *)extraLarge __attribute__((swift_name("doCopy(extraSmall:small:medium:large:extraLarge:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DesignSystemFoundationCornerBasedShape *extraLarge __attribute__((swift_name("extraLarge")));
@property (readonly) DesignSystemFoundationCornerBasedShape *extraSmall __attribute__((swift_name("extraSmall")));
@property (readonly) DesignSystemFoundationCornerBasedShape *large __attribute__((swift_name("large")));
@property (readonly) DesignSystemFoundationCornerBasedShape *medium __attribute__((swift_name("medium")));
@property (readonly) DesignSystemFoundationCornerBasedShape *small __attribute__((swift_name("small")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("RuntimeCompositionLocal")))
@interface DesignSystemRuntimeCompositionLocal<T> : DesignSystemBase
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("RuntimeProvidableCompositionLocal")))
@interface DesignSystemRuntimeProvidableCompositionLocal<T> : DesignSystemRuntimeCompositionLocal<T>
- (DesignSystemRuntimeProvidedValue<T> *)providesValue:(T _Nullable)value __attribute__((swift_name("provides(value:)")));
- (DesignSystemRuntimeProvidedValue<T> *)providesComputedCompute:(T _Nullable (^)(id<DesignSystemRuntimeCompositionLocalAccessorScope>))compute __attribute__((swift_name("providesComputed(compute:)")));
- (DesignSystemRuntimeProvidedValue<T> *)providesDefaultValue:(T _Nullable)value __attribute__((swift_name("providesDefault(value:)")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol DesignSystemKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LibraryResourceItem")))
@interface DesignSystemLibraryResourceItem : DesignSystemBase
- (instancetype)initWithQualifiers:(NSSet<id<DesignSystemLibraryQualifier>> *)qualifiers path:(NSString *)path offset:(int64_t)offset size:(int64_t)size __attribute__((swift_name("init(qualifiers:path:offset:size:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemLibraryResourceItem *)doCopyQualifiers:(NSSet<id<DesignSystemLibraryQualifier>> *)qualifiers path:(NSString *)path offset:(int64_t)offset size:(int64_t)size __attribute__((swift_name("doCopy(qualifiers:path:offset:size:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiImageVector.Companion")))
@interface DesignSystemUiImageVectorCompanion : DesignSystemBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) DesignSystemUiImageVectorCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("UiVectorNode")))
@interface DesignSystemUiVectorNode : DesignSystemBase
@end

__attribute__((swift_name("KotlinIterable")))
@protocol DesignSystemKotlinIterable
@required
- (id<DesignSystemKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UiVectorGroup")))
@interface DesignSystemUiVectorGroup : DesignSystemUiVectorNode <DesignSystemKotlinIterable>
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (DesignSystemUiVectorNode *)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (id<DesignSystemKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@property (readonly) NSArray<DesignSystemUi_graphicsPathNode *> *clipPathData __attribute__((swift_name("clipPathData")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) float pivotX __attribute__((swift_name("pivotX")));
@property (readonly) float pivotY __attribute__((swift_name("pivotY")));
@property (readonly) float rotation __attribute__((swift_name("rotation")));
@property (readonly) float scaleX __attribute__((swift_name("scaleX")));
@property (readonly) float scaleY __attribute__((swift_name("scaleY")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@property (readonly) float translationX __attribute__((swift_name("translationX")));
@property (readonly) float translationY __attribute__((swift_name("translationY")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinCoroutineContext")))
@protocol DesignSystemKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<DesignSystemKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<DesignSystemKotlinCoroutineContextElement> _Nullable)getKey:(id<DesignSystemKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<DesignSystemKotlinCoroutineContext>)minusKeyKey:(id<DesignSystemKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<DesignSystemKotlinCoroutineContext>)plusContext:(id<DesignSystemKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
__attribute__((swift_name("Ui_graphicsShape")))
@protocol DesignSystemUi_graphicsShape
@required
- (DesignSystemUi_graphicsOutline *)createOutlineSize:(int64_t)size layoutDirection:(DesignSystemUi_unitLayoutDirection *)layoutDirection density:(id<DesignSystemUi_unitDensity>)density __attribute__((swift_name("createOutline(size:layoutDirection:density:)")));
@end

__attribute__((swift_name("FoundationCornerBasedShape")))
@interface DesignSystemFoundationCornerBasedShape : DesignSystemBase <DesignSystemUi_graphicsShape>
- (instancetype)initWithTopStart:(id<DesignSystemFoundationCornerSize>)topStart topEnd:(id<DesignSystemFoundationCornerSize>)topEnd bottomEnd:(id<DesignSystemFoundationCornerSize>)bottomEnd bottomStart:(id<DesignSystemFoundationCornerSize>)bottomStart __attribute__((swift_name("init(topStart:topEnd:bottomEnd:bottomStart:)"))) __attribute__((objc_designated_initializer));
- (DesignSystemFoundationCornerBasedShape *)doCopyAll:(id<DesignSystemFoundationCornerSize>)all __attribute__((swift_name("doCopy(all:)")));
- (DesignSystemFoundationCornerBasedShape *)doCopyTopStart:(id<DesignSystemFoundationCornerSize>)topStart topEnd:(id<DesignSystemFoundationCornerSize>)topEnd bottomEnd:(id<DesignSystemFoundationCornerSize>)bottomEnd bottomStart:(id<DesignSystemFoundationCornerSize>)bottomStart __attribute__((swift_name("doCopy(topStart:topEnd:bottomEnd:bottomStart:)")));
- (DesignSystemUi_graphicsOutline *)createOutlineSize:(int64_t)size layoutDirection:(DesignSystemUi_unitLayoutDirection *)layoutDirection density:(id<DesignSystemUi_unitDensity>)density __attribute__((swift_name("createOutline(size:layoutDirection:density:)")));
- (DesignSystemUi_graphicsOutline *)createOutlineSize:(int64_t)size topStart:(float)topStart topEnd:(float)topEnd bottomEnd:(float)bottomEnd bottomStart:(float)bottomStart layoutDirection:(DesignSystemUi_unitLayoutDirection *)layoutDirection __attribute__((swift_name("createOutline(size:topStart:topEnd:bottomEnd:bottomStart:layoutDirection:)")));
@property (readonly) id<DesignSystemFoundationCornerSize> bottomEnd __attribute__((swift_name("bottomEnd")));
@property (readonly) id<DesignSystemFoundationCornerSize> bottomStart __attribute__((swift_name("bottomStart")));
@property (readonly) id<DesignSystemFoundationCornerSize> topEnd __attribute__((swift_name("topEnd")));
@property (readonly) id<DesignSystemFoundationCornerSize> topStart __attribute__((swift_name("topStart")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RuntimeProvidedValue")))
@interface DesignSystemRuntimeProvidedValue<T> : DesignSystemBase
@property (readonly) BOOL canOverride __attribute__((swift_name("canOverride")));
@property (readonly) DesignSystemRuntimeCompositionLocal<T> *compositionLocal __attribute__((swift_name("compositionLocal")));
@property (readonly) T _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("RuntimeCompositionLocalAccessorScope")))
@protocol DesignSystemRuntimeCompositionLocalAccessorScope
@required
- (id _Nullable)currentValue:(DesignSystemRuntimeCompositionLocal<id> *)receiver __attribute__((swift_name("currentValue(_:)")));
@end

__attribute__((swift_name("LibraryQualifier")))
@protocol DesignSystemLibraryQualifier
@required
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((swift_name("Ui_graphicsPathNode")))
@interface DesignSystemUi_graphicsPathNode : DesignSystemBase
@property (readonly) BOOL isCurve __attribute__((swift_name("isCurve")));
@property (readonly) BOOL isQuad __attribute__((swift_name("isQuad")));
@end

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol DesignSystemKotlinCoroutineContextElement <DesignSystemKotlinCoroutineContext>
@required
@property (readonly) id<DesignSystemKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol DesignSystemKotlinCoroutineContextKey
@required
@end

__attribute__((swift_name("Ui_graphicsOutline")))
@interface DesignSystemUi_graphicsOutline : DesignSystemBase
@property (readonly) DesignSystemUi_geometryRect *bounds __attribute__((swift_name("bounds")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ui_unitLayoutDirection")))
@interface DesignSystemUi_unitLayoutDirection : DesignSystemKotlinEnum<DesignSystemUi_unitLayoutDirection *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) DesignSystemUi_unitLayoutDirection *ltr __attribute__((swift_name("ltr")));
@property (class, readonly) DesignSystemUi_unitLayoutDirection *rtl __attribute__((swift_name("rtl")));
+ (DesignSystemKotlinArray<DesignSystemUi_unitLayoutDirection *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<DesignSystemUi_unitLayoutDirection *> *entries __attribute__((swift_name("entries")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
 *   androidx.annotation.RestrictTo(value=[Scope.LIBRARY_GROUP])
*/
__attribute__((swift_name("Ui_unitFontScalingLinear")))
@protocol DesignSystemUi_unitFontScalingLinear
@required

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (float)toDp__:(int64_t)receiver __attribute__((swift_name("toDp(___:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int64_t)toSp__:(float)receiver __attribute__((swift_name("toSp(___:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float fontScale __attribute__((swift_name("fontScale")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((swift_name("Ui_unitDensity")))
@protocol DesignSystemUi_unitDensity <DesignSystemUi_unitFontScalingLinear>
@required

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int32_t)roundToPx:(float)receiver __attribute__((swift_name("roundToPx(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int32_t)roundToPx_:(int64_t)receiver __attribute__((swift_name("roundToPx(__:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (float)toDp:(float)receiver __attribute__((swift_name("toDp(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (float)toDp_:(int32_t)receiver __attribute__((swift_name("toDp(__:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int64_t)toDpSize:(int64_t)receiver __attribute__((swift_name("toDpSize(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (float)toPx:(float)receiver __attribute__((swift_name("toPx(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (float)toPx_:(int64_t)receiver __attribute__((swift_name("toPx(__:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)toRect:(DesignSystemUi_unitDpRect *)receiver __attribute__((swift_name("toRect(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int64_t)toSize:(int64_t)receiver __attribute__((swift_name("toSize(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int64_t)toSp:(float)receiver __attribute__((swift_name("toSp(_:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (int64_t)toSp_:(int32_t)receiver __attribute__((swift_name("toSp(__:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float density __attribute__((swift_name("density")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((swift_name("FoundationCornerSize")))
@protocol DesignSystemFoundationCornerSize
@required
- (float)toPxShapeSize:(int64_t)shapeSize density:(id<DesignSystemUi_unitDensity>)density __attribute__((swift_name("toPx(shapeSize:density:)")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ui_geometryRect")))
@interface DesignSystemUi_geometryRect : DesignSystemBase
- (instancetype)initWithLeft:(float)left top:(float)top right:(float)right bottom:(float)bottom __attribute__((swift_name("init(left:top:right:bottom:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) DesignSystemUi_geometryRectCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)containsOffset:(int64_t)offset __attribute__((swift_name("contains(offset:)")));
- (DesignSystemUi_geometryRect *)doCopyLeft:(float)left top:(float)top right:(float)right bottom:(float)bottom __attribute__((swift_name("doCopy(left:top:right:bottom:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)deflateDelta:(float)delta __attribute__((swift_name("deflate(delta:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)inflateDelta:(float)delta __attribute__((swift_name("inflate(delta:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)intersectOther:(DesignSystemUi_geometryRect *)other __attribute__((swift_name("intersect(other:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)intersectOtherLeft:(float)otherLeft otherTop:(float)otherTop otherRight:(float)otherRight otherBottom:(float)otherBottom __attribute__((swift_name("intersect(otherLeft:otherTop:otherRight:otherBottom:)")));
- (BOOL)overlapsOther:(DesignSystemUi_geometryRect *)other __attribute__((swift_name("overlaps(other:)")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)translateOffset:(int64_t)offset __attribute__((swift_name("translate(offset:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
- (DesignSystemUi_geometryRect *)translateTranslateX:(float)translateX translateY:(float)translateY __attribute__((swift_name("translate(translateX:translateY:)")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float bottom __attribute__((swift_name("bottom")));
@property (readonly) int64_t bottomCenter __attribute__((swift_name("bottomCenter")));
@property (readonly) int64_t bottomLeft __attribute__((swift_name("bottomLeft")));
@property (readonly) int64_t bottomRight __attribute__((swift_name("bottomRight")));
@property (readonly) int64_t center __attribute__((swift_name("center")));
@property (readonly) int64_t centerLeft __attribute__((swift_name("centerLeft")));
@property (readonly) int64_t centerRight __attribute__((swift_name("centerRight")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float height __attribute__((swift_name("height")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) BOOL isEmpty __attribute__((swift_name("isEmpty")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) BOOL isFinite __attribute__((swift_name("isFinite")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) BOOL isInfinite __attribute__((swift_name("isInfinite")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float left __attribute__((swift_name("left")));
@property (readonly) float maxDimension __attribute__((swift_name("maxDimension")));
@property (readonly) float minDimension __attribute__((swift_name("minDimension")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float right __attribute__((swift_name("right")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) int64_t size __attribute__((swift_name("size")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float top __attribute__((swift_name("top")));
@property (readonly) int64_t topCenter __attribute__((swift_name("topCenter")));
@property (readonly) int64_t topLeft __attribute__((swift_name("topLeft")));
@property (readonly) int64_t topRight __attribute__((swift_name("topRight")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float width __attribute__((swift_name("width")));
@end


/**
 * @note annotations
 *   androidx.compose.runtime.Immutable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ui_unitDpRect")))
@interface DesignSystemUi_unitDpRect : DesignSystemBase
- (instancetype)initWithOrigin:(int64_t)origin size:(int64_t)size __attribute__((swift_name("init(origin:size:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithLeft:(float)left top:(float)top right:(float)right bottom:(float)bottom __attribute__((swift_name("init(left:top:right:bottom:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) DesignSystemUi_unitDpRectCompanion *companion __attribute__((swift_name("companion")));
- (DesignSystemUi_unitDpRect *)doCopyLeft:(float)left top:(float)top right:(float)right bottom:(float)bottom __attribute__((swift_name("doCopy(left:top:right:bottom:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float bottom __attribute__((swift_name("bottom")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float left __attribute__((swift_name("left")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float right __attribute__((swift_name("right")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) float top __attribute__((swift_name("top")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ui_geometryRect.Companion")))
@interface DesignSystemUi_geometryRectCompanion : DesignSystemBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) DesignSystemUi_geometryRectCompanion *shared __attribute__((swift_name("shared")));

/**
 * @note annotations
 *   androidx.compose.runtime.Stable
*/
@property (readonly) DesignSystemUi_geometryRect *Zero __attribute__((swift_name("Zero")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ui_unitDpRect.Companion")))
@interface DesignSystemUi_unitDpRectCompanion : DesignSystemBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) DesignSystemUi_unitDpRectCompanion *shared __attribute__((swift_name("shared")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
